/* TAG_ORB_TYPE.java --
   Copyright (C) 2005 Free Software Foundation, Inc.

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


package org.omg.IOP;

/**
 * <p>
 * Holds an integer constant of the TAG_ORB_TYPE Component that defines
 * the kind or CORBA implementation of ORB the reference is comming from.
 * This information may be useful to work around problems with that
 * particular ORB, or exploit shared efficiencies. This tag contains
 * a single unsigned long value; these values are managed by OMG group.
 * </p><p>
 * Anyone may register any ORB types by submitting a one-paragraph
 * description of the ORB type to the OMG, and will receive a new ORB
 * type ID in return. A list of all ORB type descriptions should be
 * available on the OMG web server.
 * </p><p>
 * TODO Register the GNU Classpath kind of ORB. Not registered at the moment.
 * <p>
 * @see TAG_INTERNET_IOP
 * @see TAG_MULTIPLE_COMPONENTS
 *
 * @author Audrius Meskauskas, Lithuania (AudriusA@Bioinformatics.org)
 */
public interface TAG_ORB_TYPE
{
  /**
   * Specifies the TAG_ORB_TYPE value, 0.
   */
  int value = 0;
}
