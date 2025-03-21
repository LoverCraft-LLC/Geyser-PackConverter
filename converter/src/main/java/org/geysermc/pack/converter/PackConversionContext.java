/*
 * Copyright (c) 2019-2023 GeyserMC. http://geysermc.org
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 *
 *  @author GeyserMC
 *  @link https://github.com/GeyserMC/PackConverter
 *
 */

package org.geysermc.pack.converter;

import org.geysermc.pack.bedrock.resource.BedrockResourcePack;
import org.geysermc.pack.converter.data.ConversionData;
import org.geysermc.pack.converter.util.LogListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import team.unnamed.creative.ResourcePack;

import java.nio.file.Path;

public record PackConversionContext<T extends ConversionData>(
        @NotNull T data,
        @NotNull PackConverter packConverter,
        @NotNull ResourcePack javaResourcePack,
        @NotNull BedrockResourcePack bedrockResourcePack,
        @NotNull LogListener logListener) {

    public Path inputDirectory() {
        return this.data.inputDirectory();
    }

    public Path outputDirectory() {
        return this.data.outputDirectory();
    }

    public void debug(@NotNull String message) {
        this.logListener.debug(message);
    }

    public void info(@NotNull String message) {
        this.logListener.info(message);
    }

    public void warn(@NotNull String message) {
        this.logListener.warn(message);
    }

    public void error(@NotNull String message) {
        this.logListener.error(message);
    }

    public void error(@NotNull String message, @NotNull Throwable exception) {
        this.logListener.error(message, exception);
    }
}
