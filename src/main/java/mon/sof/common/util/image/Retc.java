package mon.sof.common.util.image;

public class Retc
{
  private int width = 0;
  private int heigth = 0;
  private int top = 0;
  private int left = 0;
  
  public Retc(int width, int height)
  {
    this.width = width;
    this.heigth = height;
  }
  
  public Retc() {}
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void setWidth(int width)
  {
    this.width = width;
  }
  
  public int getHeigth()
  {
    return this.heigth;
  }
  
  public void setHeigth(int heigth)
  {
    this.heigth = heigth;
  }
  
  public int getTop()
  {
    return this.top;
  }
  
  public void setTop(int top)
  {
    this.top = top;
  }
  
  public int getLeft()
  {
    return this.left;
  }
  
  public void setLeft(int left)
  {
    this.left = left;
  }
}
