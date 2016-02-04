/*
 * Copyright (c) 2013, 2016 Oracle and/or its affiliates. All rights reserved. This
 * code is released under a tri EPL/GPL/LGPL license. You can use it,
 * redistribute it and/or modify it under the terms of the:
 *
 * Eclipse Public License version 1.0
 * GNU General Public License version 2
 * GNU Lesser General Public License version 2.1
 */
package org.jruby.truffle.language.arguments;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.source.SourceSection;
import org.jruby.truffle.RubyContext;
import org.jruby.truffle.language.RubyNode;

/**
 * Read a post argument.
 */
public class ReadPostArgumentNode extends RubyNode {

    private final int negativeIndex;

    public ReadPostArgumentNode(RubyContext context, SourceSection sourceSection, int negativeIndex) {
        super(context, sourceSection);
        this.negativeIndex = negativeIndex;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        final int count = RubyArguments.getArgumentsCount(frame.getArguments());
        final int effectiveIndex = count + negativeIndex;
        assert effectiveIndex < count;
        return RubyArguments.getArgument(frame.getArguments(), effectiveIndex);
    }

}