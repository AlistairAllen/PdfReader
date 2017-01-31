package me.alistairallen.pdf.util;

import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestIoHelper
{
  private IoHelper mIohelper;
  
  @BeforeClass
  public static void prepare()
  {
    BasicConfigurator.resetConfiguration();
    BasicConfigurator.configure();
  }
  
  @Before
  public void setup()
  {
    mIohelper = new IoHelper();
  }
  
  @Test
  public void closeWriter() throws IOException
  {
    Writer writer = null;
    mIohelper.closeWriter(writer);
    
    writer = new CharArrayWriter();
    mIohelper.closeWriter(writer);

    writer = new StringWriter()
    {
      @Override
      public void close() throws IOException
      {
        super.close();
        throw new IOException("this is a test");
      }
    };
    mIohelper.closeWriter(writer);
  }

  @Test
  public void closeOutputStream() throws IOException
  {
    OutputStream stream = null;
    mIohelper.closeOutputStream(stream);
    
    stream = new ByteArrayOutputStream();
    mIohelper.closeOutputStream(stream);

    stream = new ByteArrayOutputStream()
    {
      @Override
      public void close() throws IOException
      {
        super.close();
        throw new IOException("this is a test");
      }
    };
    mIohelper.closeOutputStream(stream);
  }
}