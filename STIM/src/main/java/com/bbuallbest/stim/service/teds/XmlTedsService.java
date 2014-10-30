package com.bbuallbest.stim.service.teds;

import com.bbuallbest.stim.entity.teds.ChannelTeds;
import com.bbuallbest.stim.entity.teds.MetaTeds;
import com.bbuallbest.stim.service.util.StimPropertyHandler;
import com.bbuallbest.stim.util.Path;
import com.bbuallbest.stim.util.Stim;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlTedsService implements TedsService {

    @Inject
    private StimPropertyHandler propertyHandler;

    public XmlTedsService() {}

    @Override
    public MetaTeds getMetaTeds() {
        String metaTedsFile = propertyHandler.getProperty(Stim.META_TEDS.getProperty());
        return getTedsFromXml(metaTedsFile, MetaTeds.class);
    }

    @Override
    public ChannelTeds getChannelTeds(int channelNumber) {
        String channelAmount = propertyHandler.getProperty(Stim.CHANNEL_AMOUNT.getProperty());
        if(Integer.parseInt(channelAmount) < channelNumber + 1)
            return null;

        StringBuilder channelTedsFile = new StringBuilder();
        channelTedsFile.append(propertyHandler.getProperty(Stim.CHANNEL_TEDS_PREFIX.getProperty()));
        channelTedsFile.append(propertyHandler.getProperty(Stim.CHANNEL_ID.getProperty() + channelNumber));
        channelTedsFile.append(propertyHandler.getProperty(Stim.CHANNEL_TEDS_EXTENSION.getProperty()));

        return getTedsFromXml(channelTedsFile.toString(), ChannelTeds.class);
    }

    private <T> T getTedsFromXml(String fileName, Class<T> type) {
        T teds = null;

        try {

//            File file = new File(Path.TEDS_DIR.getPath() + fileName);
            File file = new File(propertyHandler.getProperty(Stim.TEDS_PATH.getProperty()) + fileName);
            JAXBContext context = JAXBContext.newInstance(type);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            teds = type.cast(unmarshaller.unmarshal(file));
        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            return teds;
        }
    }
}
