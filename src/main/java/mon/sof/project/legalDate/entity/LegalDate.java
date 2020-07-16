package mon.sof.project.legalDate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zxm
 * @since 2020-03-17
 */
public class LegalDate implements Serializable {


    /**
     * id
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 法定日期
     */
    private Date date;

    /**
     * 节假日名字
     */
    private String legalName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    @Override
    public String toString() {
        return "LegalDate{" +
        "id=" + id +
        ", date=" + date +
        ", legalName=" + legalName +
        "}";
    }
}
