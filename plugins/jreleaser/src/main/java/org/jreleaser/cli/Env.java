/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2020-2023 The JReleaser authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jreleaser.cli;

import org.jreleaser.cli.internal.ColorizedJReleaserLoggerAdapter;
import org.jreleaser.engine.environment.Environment;
import org.jreleaser.logging.JReleaserLogger;
import picocli.CommandLine;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import static org.jreleaser.util.IoUtils.newPrintWriter;

/**
 * @author Andres Almiray
 * @since 1.5.0
 */
@CommandLine.Command(name = "env")
public class Env extends AbstractCommand<Main> {
    @Override
    protected void execute() {
        Environment.display(initLogger());
    }

    protected JReleaserLogger initLogger() {
        return new ColorizedJReleaserLoggerAdapter(createTracer(), parent().getOut(), ColorizedJReleaserLoggerAdapter.Level.INFO);
    }

    protected PrintWriter createTracer() {
        return newPrintWriter(new ByteArrayOutputStream());
    }
}
