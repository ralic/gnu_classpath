/* ServerDHParams.java -- The server's Diffie-Hellman parameters.
   Copyright (C) 2006  Free Software Foundation, Inc.

This file is a part of GNU Classpath.

GNU Classpath is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or (at
your option) any later version.

GNU Classpath is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License
along with GNU Classpath; if not, write to the Free Software
Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301
USA

Linking this library statically or dynamically with other modules is
making a combined work based on this library.  Thus, the terms and
conditions of the GNU General Public License cover the whole
combination.

As a special exception, the copyright holders of this library give you
permission to link this library with independent modules to produce an
executable, regardless of the license terms of these independent
modules, and to copy and distribute the resulting executable under
terms of your choice, provided that you also meet, for each linked
independent module, the terms and conditions of the license of that
module.  An independent module is a module which is not derived from
or based on this library.  If you modify this library, you may extend
this exception to your version of the library, but you are not
obligated to do so.  If you do not wish to do so, delete this
exception statement from your version.  */


package gnu.javax.net.ssl.provider;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.nio.ByteBuffer;

/**
 * The server's Diffie-Hellman parameters message.
 *
 * <pre>
struct
{
  opaque dh_p&lt;1..2^16-1&gt;;
  opaque dh_g&lt;1..2^16-1&gt;;
  opaque dh_Ys&lt;1..2^16-1&gt;;
} ServerDHParams;
</pre>
 */
public class ServerDHParams implements ServerKeyExchangeParams
{
  private final ByteBuffer buffer;

  public ServerDHParams (final ByteBuffer buffer)
  {
    this.buffer = buffer;
  }

  public KeyExchangeAlgorithm algorithm ()
  {
    return KeyExchangeAlgorithm.DIFFIE_HELLMAN;
  }

  public int length ()
  {
    int offset1 = buffer.getShort (0) & 0xFFFF;
    int offset2 = buffer.getShort (offset1 + 2) & 0xFFFF;
    return ((buffer.getShort (offset1 + offset2 + 4) & 0xFFFF)
            + offset1 + offset2 + 6);
  }

  /**
   * Returns the server's prime modulus.
   *
   * @return p.
   */
  public BigInteger p ()
  {
    int len = buffer.getShort (0) & 0xFFFF;
    byte[] buf = new byte[len];
    buffer.position (2);
    buffer.get (buf);
    return new BigInteger (1, buf);
  }

  /**
   * Returns the server's generator value.
   *
   * @return g.
   */
  public BigInteger g ()
  {
    int off = (buffer.getShort (0) & 0xFFFF) + 2;
    int len = buffer.getShort (off) & 0xFFFF;
    byte[] buf = new byte[len];
    buffer.position (off + 2);
    buffer.get (buf);
    return new BigInteger (1, buf);
  }

  /**
   * Returns the server's public value.
   *
   * @return Y.
   */
  public BigInteger y ()
  {
    int offset1 = (buffer.getShort (0) & 0xFFFF) + 2;
    int offset2 = (buffer.getShort (offset1) & 0xFFFF) + offset1 + 2;
    int len = buffer.getShort (offset2) & 0xFFFF;
    byte[] buf = new byte[len];
    buffer.position (offset2 + 2);
    buffer.get (buf);
    return new BigInteger (1, buf);
  }

  /**
   * Sets the server's prime modulus, p.
   *
   * @param p The p parameter.
   * @throws java.nio.ReadOnlyBufferException If the underlying buffer
   * is not writeable.
   */
  public void setP (final BigInteger p)
  {
    byte[] buf = p.toByteArray ();
    int length = (buf[0] == 0x00 ? buf.length - 1 : buf.length);
    int offset = (buf[0] == 0x00 ? 1 : 0);
    buffer.putShort (0, (short) length);
    buffer.position (2);
    buffer.put (buf, offset, length);
  }

  /**
   * Sets the server's generator value, g.
   *
   * @param g The g parameter.
   * @throws java.nio.ReadOnlyBufferException If the underlying buffer
   * is not writeable.
   */
  public void setG (final BigInteger g)
  {
    byte[] buf = g.toByteArray ();
    int length = (buf[0] == 0x00 ? buf.length -1 : buf.length);
    int offset = (buf[0] == 0x00 ? 1 : 0);
    int where = (buffer.getShort (0) & 0xFFFF) + 2;
    buffer.putShort (where, (short) length);
    buffer.position (where + 2);
    buffer.put (buf, offset, length);
  }

  /**
   * Sets the server's public value, Y.
   *
   * @param y The Y parameter.
   * @throws java.nio.ReadOnlyBufferException If the underlying buffer
   * is not writeable.
   */
  public void setY (final BigInteger y)
  {
    int offset1 = (buffer.getShort (0) & 0xFFFF) + 2;
    int offset2 = (buffer.getShort (offset1) & 0xFFFF) + offset1 + 2;
    byte[] buf = y.toByteArray ();
    int length = (buf[0] == 0x00 ? buf.length -1 : buf.length);
    int offset = (buf[0] == 0x00 ? 1 : 0);
    buffer.putShort (offset2, (short) length);
    buffer.position (offset2 + 2);
    buffer.put (buf, offset, length);
  }

  public String toString ()
  {
    return toString (null);
  }

  public String toString (final String prefix)
  {
    StringWriter str = new StringWriter ();
    PrintWriter out = new PrintWriter (str);
    if (prefix != null) out.print (prefix);
    out.println ("struct {");
    if (prefix != null) out.print (prefix);
    out.print ("  dh_p:  ");
    out.println (p ().toString (16));
    if (prefix != null) out.print (prefix);
    out.print ("  dh_g:  ");
    out.println (g ().toString (16));
    if (prefix != null) out.print (prefix);
    out.print ("  dh_Ys: ");
    out.println (y ().toString (16));
    if (prefix != null) out.print (prefix);
    out.print ("} ServerDHParams;");
    return str.toString ();
  }
}