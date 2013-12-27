package org.eluder.coveralls.maven.plugin.saga;

/*
 * #[license]
 * coveralls-maven-plugin
 * %%
 * Copyright (C) 2013 Tapio Rautonen
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * %[license]
 */

import org.apache.maven.plugin.logging.Log;
import org.eluder.coveralls.maven.plugin.AbstractCoverallsMojo;
import org.eluder.coveralls.maven.plugin.AbstractCoverallsMojoTest;
import org.eluder.coveralls.maven.plugin.CoverageFixture;
import org.eluder.coveralls.maven.plugin.util.TestIoUtil;

import static org.mockito.Mockito.verify;

/**
 * @author Jakub Bednář (25/12/2013 10:03)
 */
public class SagaMojoTest extends AbstractCoverallsMojoTest {

    @Override
    protected AbstractCoverallsMojo createMojo() {
        SagaMojo mojo = new SagaMojo();

        mojo.coverageFile = TestIoUtil.getFile("/saga.xml");
        mojo.deployedDirectoryName = "";

        return mojo;
    }

    @Override
    protected String[][] getCoverageFiles() {
        return CoverageFixture.COVERAGE_FILES_SAGA;
    }

    @Override
    protected void verifySuccesfull(final Log logMock) {
        verify(logMock).info("Gathered code coverage metrics for 1 source files with 5 lines of code:");
        verify(logMock).info("*** It might take hours for Coveralls to update the actual coverage numbers for a job");
    }
}
