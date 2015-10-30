package de.afbb.bibo.share.internal.stub.impl;

import java.net.ConnectException;

import de.afbb.bibo.share.ICuratorService;
import de.afbb.bibo.share.model.Curator;

public class CuratorStubService implements ICuratorService {

	@Override
	public boolean exists(final String curatorName) throws ConnectException {
		return "Hugo".equals(curatorName);
	}

	@Override
	public void create(final Curator curator) throws ConnectException {
		if ("Horst".equals(curator.getName())) {
			throw new ConnectException();
		}
		// nothing to do in stub service
	}

}
