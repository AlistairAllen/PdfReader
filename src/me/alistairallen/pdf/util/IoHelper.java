package me.alistairallen.pdf.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

import org.apache.log4j.Logger;

public class IoHelper
{
  private Logger mLogger = Logger.getLogger(IoHelper.class);

  /**
   * Closes the writer handling null parameters and errors
   * @param aWriter the writer
   */
  public void closeWriter(Writer aWriter)
  {
    if (aWriter != null)
    {
      try
      {
        aWriter.flush();
        aWriter.close();
      }
      catch (IOException ioe)
      {
        mLogger.error("Error closing writer", ioe);
      }
    }
  }

  /**
   * Closes the output stream handling null parameters and errors
   * @param aOutputStream the output stream
   */
  public void closeOutputStream(OutputStream aOutputStream)
  {
    if (aOutputStream != null)
    {
      try
      {
        aOutputStream.close();
      }
      catch (IOException ioe)
      {
        mLogger.error("Error closing output stream", ioe);
      }
    }
  }
}
