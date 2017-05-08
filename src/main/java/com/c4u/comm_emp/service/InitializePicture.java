/*
 * InitializePicture.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javafx.scene.image.Image;
import sun.misc.BASE64Decoder;

/**
 * TODO : Description.
 */
public class InitializePicture
{
  Image image;

  /**
   * @return Image
   */
  public Image getImage()
  {
    return image;
  }

  /**
   * @param theImage Image
   */
  public void setImage(final Image theImage)
  {
    image = theImage;
  }

  /**
   * @param theImageName String
   * @throws IOException
   */
  public InitializePicture(final String theImageName)
      throws IOException
  {
    // TODO Auto-generated constructor stub
    final URL _url = getClass().getResource("/image/" + theImageName);
    final StringBuffer _fileData = new StringBuffer();
    final BufferedReader _reader = new BufferedReader(new FileReader(_url.getPath()));
    final char[] _buf = new char[1024];
    int _numRead = 0;
    while ((_numRead = _reader.read(_buf)) != -1)
    {
      final String _readData = String.valueOf(_buf, 0, _numRead);
      _fileData.append(_readData);
    }
    _reader.close();
    final String _imgStr = _fileData.toString();
    @SuppressWarnings("restriction")
    final BASE64Decoder _base64Decoder = new BASE64Decoder();
    @SuppressWarnings("restriction")
    final ByteArrayInputStream _imgInputStream = new ByteArrayInputStream(_base64Decoder.decodeBuffer(_imgStr));
    setImage(new Image(_imgInputStream));

  }

}
