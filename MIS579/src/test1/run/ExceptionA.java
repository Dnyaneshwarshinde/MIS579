package test1.run;
public class ExceptionA extends Exception {

  public ExceptionA() {
    this("ExceptionA");
  }

  public ExceptionA(String arg0) {
    super(arg0);
  }

  public ExceptionA(Throwable arg0) {
    super(arg0);
  }

  public ExceptionA(String arg0, Throwable arg1) {
    super(arg0, arg1);
    
  }

}

