/* target_native_misc.h - Miscallaneous operations for the RTEMS platform
   Copyright (C) 2006 Free Software Foundation, Inc.

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

/*
Description: RTEMS target defintions of miscellaneous functions
Systems    : RTEMS
*/

#ifndef __TARGET_NATIVE_MISC__
#define __TARGET_NATIVE_MISC__

/****************************** Includes *******************************/
/* do not move; needed here because of some macro definitions */
#include <config.h>

#include <stdlib.h>

/****************** Conditional compilation switches *******************/

/***************************** Constants *******************************/

/***************************** Datatypes *******************************/

/***************************** Variables *******************************/

/****************************** Macros *********************************/

// NYI: COMMENT:
#define TARGET_NATIVE_MISC_GET_TIMEZONE_STRING(string,maxStringLength,result) \
  do { \
    result = TARGET_NATIVE_ERROR; \
  } while (0)

/***************************** Functions *******************************/

#ifdef __cplusplus
extern "C" {
#endif

#ifdef __cplusplus
}
#endif



/* include rest of definitions from generic file (do not move it to 
   another position!) */
#include "target_generic_misc.h"

#endif /* __TARGET_NATIVE_MISC__ */

/* end of file */
