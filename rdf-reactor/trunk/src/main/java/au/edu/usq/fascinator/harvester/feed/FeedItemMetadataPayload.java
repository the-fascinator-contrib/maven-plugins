/* 
 * The Fascinator - Common Library
 * Copyright (C) 2008 University of Southern Queensland
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package au.edu.usq.fascinator.harvester.feed;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import au.edu.usq.fascinator.api.storage.PayloadType;
import au.edu.usq.fascinator.common.storage.impl.GenericPayload;
import au.edu.usq.fascinator.contrib.feedreader.FeedHelper;

import com.sun.syndication.feed.synd.SyndEntry;

public class FeedItemMetadataPayload extends GenericPayload {

    private SyndEntry feedEntry;

    public FeedItemMetadataPayload(SyndEntry payload) {
        this.feedEntry = payload;
        setId("metadata");
        setLabel("RSS/ATOM Feed");
        setContentType("text/xml");
        setType(PayloadType.Annotation);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return IOUtils.toInputStream(FeedHelper.toRDFXML(feedEntry));
    }
}
