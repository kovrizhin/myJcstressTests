/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package org.sample;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.LongResult2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 12/26/16
 */
@JCStressTest
@State
@Outcome(id = "1, 1", expect = Expect.FORBIDDEN)
@Outcome(id = "2, 1", expect = Expect.ACCEPTABLE)
@Outcome(id = "1, 2", expect = Expect.ACCEPTABLE )
@Outcome(id = "2, 2", expect = Expect.FORBIDDEN)
public class AddMessageTest {
    List<String> strings = new ArrayList<>();

    @Actor
    public void actor1(LongResult2 r) {
        strings.add("test");
        r.r1 = strings.size();
    }

    @Actor
    public void actor2(LongResult2 r) {
        strings.add("test");
        r.r2 = strings.size();
    }
}
