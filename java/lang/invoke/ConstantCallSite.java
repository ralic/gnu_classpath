/* ConstantCallSite.java -- Constant call site for invokedynamic.
   Copyright (C) 2011 Free Software Foundation

This file is part of GNU Classpath.

GNU Classpath is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2, or (at your option)
any later version.

GNU Classpath is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License
along with GNU Classpath; see the file COPYING.  If not, write to the
Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
02110-1301 USA.

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
exception statement from your version. */

package java.lang.invoke;

/**
 * @since 1.7
 */
public class ConstantCallSite
  extends CallSite
{
  public ConstantCallSite(MethodHandle target)
  {
    super(target.type());

    this.target = target;
  }

  protected ConstantCallSite(MethodType type, MethodHandle hook)
    throws Throwable
  {
    super(type);

    MethodHandle target = (MethodHandle) hook.invoke(this);
    if (target == null)
      throw new NullPointerException();

    this.target = target;
  }

  @Override public final MethodHandle dynamicInvoker()
  {
    return VMCallSite.dynamicInvoker(this);
  }

  @Override public final MethodHandle getTarget()
  {
    if (target == null)
      throw new IllegalStateException("constructor has not completed");

    return target;
  }

  @Override public final void setTarget(MethodHandle target)
  {
    throw new UnsupportedOperationException();
  }

  private final MethodHandle target;
}