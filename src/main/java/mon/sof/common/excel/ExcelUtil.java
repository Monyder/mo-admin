package mon.sof.common.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mon.sof.common.exception.request.RequestException;
import mon.sof.common.util.FileUtil;
import mon.sof.common.util.IdUtil;
import mon.sof.common.util.PathUtil;
import mon.sof.common.util.StringUtil;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Title: ChinactSaas
 * <p>
 * Description: excel操作工具类
 * <p>
 * Copyright: Copyright (c) 2008
 * <p>
 * Company: 
 * 
 * @author TangHe
 * @version 1.0.0
 */
public class ExcelUtil {
	private static Logger log = LoggerFactory.getLogger(ExcelUtil.class);
	/**
	 * 版本
	 */
	public final static String VERSION = "V1.0";

	/**
	 * 配置文件目录的位置。所有的配置文件应设在这里。
	 */
	private String excelName;
	/**
	 * sheet
	 */
	private Map<Integer, ExcelSheet> excelSheets = new HashMap<Integer, ExcelSheet>();
	/**
	 * 操作excel对象
	 */
	private Workbook workbook;

	/**
	 * 构造方法
	 * 
	 * @param excelName
	 *            excel文件路径
	 * @throws RequestException
	 *             自定义异常
	 */
	public ExcelUtil(final String excelName) throws RequestException {
		if (FileUtil.exists(excelName)) {
			this.excelName = excelName;
		} else {
			throw new RequestException("在[" + excelName + "]路径下未找到文件。") {
				private static final long serialVersionUID = 1L;

				@Override
				public int getStatus() {
					return 200;
				}
			};
		}
	}

	/**
	 * 加载excel
	 * 
	 * @author TangHe
	 * @date 2013年11月14日 上午10:29:12
	 * @return excel文件流
	 * @throws RequestException
	 *             自定义异常
	 */
	private Workbook loadExcel() throws RequestException {
		InputStream is = null;
		try {
			if (this.workbook == null) {
				is = new FileInputStream(this.excelName);
				this.workbook = Workbook.getWorkbook(is);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RequestException("读取文件[" + excelName + "]失败。") {
				private static final long serialVersionUID = 1L;

				@Override
				public int getStatus() {
					return 200;
				}
			};
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (final IOException e) {
				log.error(e.getMessage());
			}
		}
		return this.workbook;
	}

	/**
	 * 加载sheet页
	 * 
	 * @author TangHe
	 * @date 2013年11月14日 上午10:48:05
	 * @return sheet
	 * @throws RequestException
	 *             自定义异常
	 */
	public ExcelSheet getSheet(int index) throws RequestException {
		if (excelSheets.get(index) == null) {
			excelSheets.put(index, new ExcelSheet(index));
		}

		return excelSheets.get(index);
	}
	
	/**
	 * 把内容放到map里
	 * 
	 * @author TangHe
	 * @date 2013年11月14日 下午3:00:45
	 * @throws RequestException
	 *             自定义异常
	 */
	public void readDate2Maps() throws RequestException {
		List<Object> resultObjList = null;
		List<Map<String, Object>> resultMapList = null;
		Object obj = null;
		Map<String, Object> map = null;
		boolean successFlag = true;
		StringBuffer errorMsg = new StringBuffer();
		final Workbook wb = this.loadExcel();
		// 获取所有sheet
		final Map<Integer, ExcelSheet> esMap = this.getExcelSheets();
		ExcelSheet esTemp = null;
		// 循环遍历sheet
		Iterator<Map.Entry<Integer, ExcelSheet>> iter = esMap.entrySet().iterator();
		while (iter.hasNext()) {
			resultObjList = new ArrayList<Object>();
			resultMapList = new ArrayList<Map<String, Object>>();
			final Map.Entry<Integer, ExcelSheet> sheetEntry = iter.next();
			esTemp = sheetEntry.getValue();
			// 获取映射Class
			Class<?> mapperClass = null;
			if (esTemp.getMapperClass() != null) {
				mapperClass = esTemp.getMapperClass();
			}
			// 获取sheet的行
			final ExcelRow rTemp = esTemp.getRow();
			// 获取行中的列
			final Map<Integer, ExcelColumn> clTemp = rTemp.getExcelColumns();
			// 调用workbookAPI获取sheet
			Sheet sheet = wb.getSheet(esTemp.getSheetIndex());
			esTemp.setSheet(sheet);
			Cell[] cellDomain;
			ExcelColumn excelColumn = null;
			int i = esTemp.getTitleRowIndex();
			cellDomain = sheet.getRow(i);
			outer://跳出最外层循环标识
			while (cellDomain.length > 0 && !StringUtil.isEmpty(cellDomain[0].getContents())) {
				map = new HashMap<String, Object>();
				try {
					if (mapperClass != null) {
						obj = mapperClass.newInstance();
					}
				} catch (InstantiationException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				}
				
				Iterator<Map.Entry<Integer, ExcelColumn>> columnIter = clTemp.entrySet().iterator();
				while (columnIter.hasNext()) {
					final Map.Entry<Integer, ExcelColumn> columnEntry = columnIter.next();
					excelColumn = columnEntry.getValue();
					if (StringUtils.isEmpty(excelColumn.getName())) {
						successFlag = false;
						errorMsg.append("excel文件[" + this.excelName + "]第[" + (excelColumn.getIndex() + 1) + "]列为空！");
						errorMsg.append("\r\n");
					}
					// 如果校验类不为空
					if (excelColumn.getValidators() != null) {
						for (Validator validator : excelColumn.getValidators()) {
							if(cellDomain.length < excelColumn.getIndex()) {
								successFlag = false;
								errorMsg.append("您提供的模板不正确，列数超出范围。");
								errorMsg.append("\r\n");
							}
							// 校验
							if(cellDomain[excelColumn.getIndex()].getContents().equals("f")){
								 successFlag = true;
								 break outer; //如果最后一行的值为f 表示没有行可以读取, 就会跳出最外层循环！
							}
							Map<String, Object> validateResult = validator.validateColumn(
									excelColumn.getTitle(), cellDomain[excelColumn.getIndex()].getContents().trim());
							if (!(Boolean) validateResult.get(Validator.RESULT_FLAG)) {
								successFlag = false;
								errorMsg.append("第[" + (i + 1) + "]行，第[" + (excelColumn.getIndex() + 1)+ "]列，校验未通过，"
										+ validateResult.get(Validator.RESULT_MSG));
								errorMsg.append("\r\n");
							}
						}
						
					}
					String content = null;
					try {
						content = cellDomain[excelColumn.getIndex()].getContents().trim();
					} catch (Exception e) {
					}
					if (excelColumn.getFormatter() != null) {
						content = excelColumn.getFormatter().formatColumn(content, excelColumn.getName());
						if (excelColumn.getRequired() && StringUtil.isEmpty(content)) {
							successFlag = false;
							errorMsg.append("第[" + (i + 1) + "]行，第[" + (excelColumn.getIndex() + 1)+ "]列，数据项未找到。");
							errorMsg.append("\r\n");
						}
					}
					// 普通文本处理
					if(StringUtil.isEmpty(content)){
						map.put(excelColumn.getName(), null);
					} else {
						map.put(excelColumn.getName(), content);
					}
				}
				resultMapList.add(map);
				try {
					BeanUtils.populate(obj, map);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				if (obj != null) {
					resultObjList.add(obj);
				}
				cellDomain = sheet.getRow(++i);
			}
			if (!successFlag) {
				throw new RequestException(errorMsg.toString()) {
					private static final long serialVersionUID = 1L;
					@Override
					public int getStatus() {
						return 200;
					}
				};
			}
			esTemp.setContentObjects(resultObjList);
			esTemp.setContentMaps(resultMapList);
		}
	}

	/**
	 * 读取excel
	 * 
	 * @author TangHe
	 * @date 2013年11月14日 下午5:22:27
	 * @param input
	 *            输入流
	 * @param modelExcelName
	 *            模板excel文件名
	 * @throws RequestException
	 *             自定义异常
	 */
	public void readXls(final InputStream input, final String modelExcelName) throws RequestException {
		String tempPath = PathUtil.getRealPath() + "/upload/excel" + File.separator;
		String fileName = tempPath + modelExcelName;
		File file = new File(fileName);
		int bufferSize = 1024;
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			byte[] data = new byte[bufferSize];
			int count = -1;
			while ((count = input.read(data, 0, bufferSize)) != -1) {
				os.write(data, 0, count);
			}
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			/** 获得excel文件绝对路径 */
			this.excelName = fileName;

			// excel文件路径
			// 把内容放到map里key为columnName，value为字符串集合
			readDate2Maps();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			new File(tempPath + excelName).delete();
		}
	}

	/**
	 * 创建excel文件
	 * 
	 * @author TangHe
	 * @date 2013年11月15日 上午9:16:13
	 * @return excel文件名
	 * @throws RequestException
	 *             自定义异常
	 */
	public String createXls() throws RequestException {
		// 临时存放文件夹
		final String fileName = PathUtil.getRealPath() + "/upload/excel" + File.separator
				+ IdUtil.creatUUID() + ".xls";
		final String filePath = new File(fileName).getParent();
		// 如果为zip导出路径
		Workbook wb = this.loadExcel();
		WritableWorkbook wwb;
		wwb = null;
		List<?> objects = null;
		List<Map<String, Object>> mapList = null;
		final WritableFont wfc = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
				UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK); // 正文

		// 正文样式
		final WritableCellFormat cFormat = new WritableCellFormat(wfc);

		/**
		 * 给标题添加样式设置边框
		 */
		try {
			cFormat.setBorder(Border.ALL, BorderLineStyle.THIN); // 内容样式

			/**
			 * 首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象
			 */
			final File file = new File(fileName);
			final File excelfilePath = new File(filePath);
			if (!excelfilePath.exists()) {
				excelfilePath.mkdirs();
			}
			wwb = Workbook.createWorkbook(file, wb);
			if (wwb != null) {
				/********************** 表单模板表信息 ************************************/
				// 获取所有sheet
				final Map<Integer, ExcelSheet> esMap = this.getExcelSheets();
				ExcelSheet esTemp = null;
				// 循环遍历sheet
				Iterator<Map.Entry<Integer, ExcelSheet>> iter = esMap.entrySet().iterator();
				while (iter.hasNext()) {
					final Map.Entry<Integer, ExcelSheet> sheetEntry = iter.next();
					esTemp = sheetEntry.getValue();
					if (StringUtils.isEmpty(esTemp.getSheetTitle())) {
						throw new RequestException("未获取到sheet[" + sheetEntry.getKey() + "]的标题") {
							private static final long serialVersionUID = 1L;

							@Override
							public int getStatus() {
								return 200;
							}
						};
					}
					// 数据交换方案选项卡
					final WritableSheet ws = wwb.getSheet(esTemp.getSheetIndex());
					// 设置列宽
					ws.getSettings().setDefaultColumnWidth(30);
					// 获取当前sheet的标题
					// 获取sheet的行
					final ExcelRow rTemp = esTemp.getRow();
					// 获取行中的列
					final Map<Integer, ExcelColumn> clTemp = rTemp.getExcelColumns();
					// 调用workbookAPI获取sheet
					ExcelColumn excelColumn = null;
					// 获取sheet的行
					Iterator<Map.Entry<Integer, ExcelColumn>> columnIter = clTemp.entrySet().iterator();
					objects = esTemp.getContentObjects();
					if (objects == null) {
						mapList = esTemp.getContentMaps();
					}

					while (columnIter.hasNext()) {
						final Map.Entry<Integer, ExcelColumn> columnEntry = columnIter.next();
						excelColumn = columnEntry.getValue();
						if (StringUtils.isEmpty(excelColumn.getName())) {
							throw new RequestException("未获取到第[" + (excelColumn.getIndex() + 1) + "]列的name属性！") {
								private static final long serialVersionUID = 1L;

								@Override
								public int getStatus() {
									return 200;
								}
							};
						}

						Object obj = null;
						Method[] methods = null;
						// 添加内容
						if (objects != null && !objects.isEmpty()) {
							// 循环所有行数据
							for (int i = 0; i < objects.size(); i++) {
								final StringBuffer fileNameTemp = new StringBuffer(IdUtil.creatUUID());
								fileNameTemp.append(excelColumn.getSuffix() == null ? ".txt" : excelColumn.getSuffix());
								final Class<?> clazz = objects.get(i).getClass();

								try {
									methods = clazz.getMethods();
									for (Method method : methods) {
										if (StringUtils.equals(method.getName(),
												this.getGetterName(excelColumn.getName()))) {
											obj = method.invoke(objects.get(i));
										}
									}
									if (excelColumn.getFormatter() != null) {
										obj = excelColumn.getFormatter().formatColumn(obj, excelColumn.getName());
									}
									this.addContent(ws, excelColumn, filePath, String.valueOf(obj), cFormat,
											esTemp.getTitleRowIndex() + i + 1);
								} catch (Exception e) {
									e.printStackTrace();
								}

							}
						} else {
							// 循环所有行数据
							for (int i = 0; i < mapList.size(); i++) {
								final StringBuffer fileNameTemp = new StringBuffer(IdUtil.creatUUID());
								fileNameTemp.append(excelColumn.getSuffix() == null ? ".txt" : excelColumn.getSuffix());
								Object content = mapList.get(i).get(excelColumn.getName());
								if (excelColumn.getFormatter() != null) {
									content = excelColumn.getFormatter().formatColumn(content, excelColumn.getName());
								}
								this.addContent(ws, excelColumn, filePath, String.valueOf(content), cFormat,
										esTemp.getTitleRowIndex() + i + 1);

							}
						}

					}
				}
				return fileName;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} finally {
			if (wwb != null) {
				try {
					wwb.write();
					// 关闭资源，释放内存
					wwb.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * 添加内容
	 * 
	 * @author TangHe
	 * @date 2013年11月15日 下午3:55:29
	 * @param ws
	 *            WritableSheet
	 * @param excelColumn
	 *            列
	 * @param filePath
	 *            文件路径
	 * @param content
	 *            添加内容
	 * @param format
	 *            样式
	 * @param rowIndex
	 *            行号
	 * @throws WriteException
	 *             WriteException异常
	 * @throws IOException
	 *             io异常
	 */
	private void addContent(final WritableSheet ws, final ExcelColumn excelColumn, final String filePath,
			String content, final WritableCellFormat format, int rowIndex) throws WriteException, IOException {
		final StringBuffer fileNameTemp = new StringBuffer(IdUtil.creatUUID());
		fileNameTemp.append(excelColumn.getSuffix() == null ? ".txt" : excelColumn.getSuffix());
		if (content == null || content.equals("null")) {
			content = "";
		}
		// 关联文件
		if (excelColumn.isUnionFile()) {
			FileUtil.writeFile(content, filePath + fileNameTemp.toString(), "UTF-8");
			ws.addCell(new Label(excelColumn.getIndex(), rowIndex, fileNameTemp.toString(), format));
		} else {
			// 正常
			ws.addCell(new Label(excelColumn.getIndex(), rowIndex, content, format));
		}
	}

	/**
	 * 第一个字母大写
	 * 
	 * @author TangHe
	 * @date 2013年11月15日 下午3:37:57
	 * @param str
	 *            字符串
	 * @return 大写的字符串
	 */
	private String upperFirstChar(String str) {
		String first = StringUtils.substring(str, 0, 1);
		String orther = StringUtils.substring(str, 1);
		return first.toUpperCase() + orther;
	}

	/**
	 * 是否为is开头
	 * 
	 * @author TangHe
	 * @date 2013年11月15日 下午3:39:41
	 * @param str
	 *            字符串
	 * @return 真假
	 */
	private boolean isStartWithIs(String str) {
		String first = StringUtils.substring(str, 0, 2);
		return StringUtils.equalsIgnoreCase("is", first);
	}

	/**
	 * 获得getter方法名称
	 * 
	 * @author TangHe
	 * @date 2013年11月16日 上午11:48:30
	 * @param fieldName
	 *            字段名
	 * @return getter方法名
	 */
	private String getGetterName(String fieldName) {
		String methodName = null;
		if (this.isStartWithIs(fieldName)) {
			methodName = fieldName;
		} else {
			methodName = "get" + this.upperFirstChar(fieldName);
		}
		return methodName;
	}

	/**
	 * 关闭流
	 * 
	 * @author TangHe
	 * @date 2013年11月14日 下午3:01:49
	 */
	public void close() {
		this.workbook.close();
	}

	/**
	 * 校验类
	 * 
	 * @author TangHe
	 * @date 2013年11月14日 下午3:01:49
	 */
	public interface Validator {
		/**
		 * 返回标识
		 */
		public final static String RESULT_FLAG = "result.flag";
		/**
		 * 返回信息
		 */
		public final static String RESULT_MSG = "result.msg";

		/**
		 * 校验列
		 * 
		 * @author TangHe
		 * @date 2013年11月15日 上午8:39:17
		 * @param data
		 *            列数据
		 * @return 是否通过
		 */
		Map<String, Object> validateColumn(String title, String data);
	}

	/**
	 * 校验类
	 * 
	 * @author TangHe
	 * @date 2013年11月14日 下午3:01:49
	 */
	public interface Formatter {

		/**
		 * 转换字符串
		 * 
		 * @author TangHe
		 * @date 2013年11月15日 上午8:39:17
		 * @param data
		 *            列数据
		 * @param name
		 *           列名
		 * @return 转换字符串
		 */
		String formatColumn(Object data, String name);
	}

	/**
	 * 获取无后缀名的文件名
	 * 
	 * @Title: getExcelNameUnuffix
	 * @Description:
	 * @return
	 */
	public String getExcelNameUnuffix() {

		return FileUtil.getFileNameUnuffix(this.excelName);
	}

	/**
	 * 获取无后缀名的文件名
	 * 
	 * @Title: getExcelNameUnuffix
	 * @Description:
	 * @return
	 */
	public String getExcelName() {

		return FileUtil.getFileName(this.excelName);
	}

	/**
	 * 测试
	 * 
	 * @author TangHe
	 * @date 2013年11月14日 下午2:58:49
	 * @param args
	 */
	public static void main(String[] args) {
		ExcelUtil excelUtil = null;
		try {
			// excel文件路径
			excelUtil = new ExcelUtil("D:\\录入表格-电子文档(空).xls");
			// 获取sheet页
			ExcelSheet excelSheet = excelUtil.getSheet(1);
			// excelSheet.setMapperClass(DataTableObj.class);
			excelSheet.setTitleRowIndex(1);
			// 获取行
			ExcelRow excelRow = excelSheet.getRow();
			// 获取第0列
			ExcelColumn excelColumn = excelRow.getColumn(0);
			// 对象名称
			excelColumn.setName("id");
			// 获取第1列
			ExcelColumn excelColumn1 = excelRow.getColumn(1);
			// 对象名称
			excelColumn1.setName("table");
			// 把内容放到map里key为columnName，value为字符串集合
			excelUtil.readDate2Maps();
			// List<Map<String, Object>> list = excelSheet.getContentMaps();
			// ******************************导入demo****************************************
			// excel文件路径

			// 获取sheet页
			ExcelSheet excelSheet1 = excelUtil.getSheet(0);
			// excelSheet1.setMapperClass(DataTableObj.class); // 获取行
			ExcelRow excelRow1 = excelSheet1.getRow(); // 获取第0列
			ExcelColumn excelColumn11 = excelRow1.getColumn(0); // 对象名称
			excelColumn11.setName("id"); // 获取第1列
			ExcelColumn excelColumn22 = excelRow1.getColumn(1); // 对象名称
			excelColumn22.setName("table");
			// 是否有关联文件文件
			excelColumn22.setUnionFile(true);
			excelColumn22.setSuffix("txt"); // 把内容放到map里key为columnName，value为字符串集合
			excelUtil.readXls(new FileInputStream("D:\\aaaa\\aa.xls"), "aa");
			// list = (List<DataTableObj>) excelSheet1.getContentObjects();
			// ******************************导出demo******************************
			// *********
			// *********************
			// *******第0个sheet****************************************
			// List<DataTableObj> objs = new ArrayList<DataTableObj>();
			ExcelSheet excelSheet0 = excelUtil.getSheet(0);
			excelSheet0.setSheetTitle("title");
			// excelSheet0.setContentObjects(objs);
			ExcelRow excelRow0 = excelSheet0.getRow(); // 第0个sheet第0列
			ExcelColumn excelColumn00 = excelRow0.getColumn(0);
			excelColumn00.setTitle("序号");
			excelColumn00.setName("excel_seq");
			// 第0个sheet第1列
			ExcelColumn excelColumn01 = excelRow0.getColumn(1);
			excelColumn01.setTitle("表名");
			excelColumn01.setName("tableName"); // 不可为空
			excelColumn01.setNotNull(true); // 第0个sheet第2列
			ExcelColumn excelColumn02 = excelRow0.getColumn(2);
			excelColumn02.setTitle("表注释");
			excelColumn02.setName("tableNote"); // 不可为空
			excelColumn02.setNotNull(true); // 大字段导出文件
			excelColumn02.setUnionFile(true); // 文件格式
			excelColumn02.setSuffix(".jsp");
			// String xlsName = excelUtil.createXls();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			excelUtil.close();
		}

	}

	private Map<Integer, ExcelSheet> getExcelSheets() {
		return excelSheets;
	}

}
