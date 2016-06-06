package com.voyage.model.services.releaseservice;

import com.voyage.model.domain.Release;
import com.voyage.model.services.IService;
import com.voyage.model.services.exception.ReleaseException;
import java.util.Set;

/**
 * This interface defines methods for storing and retrieving Releases
 * to and from a file system
 * @author Jason Canney
 *
 */
public interface IReleaseSvc extends IService {
	
	public final String NAME = "IReleaseSvc";
	
	/**
	 * Persists a Release
	 * The storeRelease interface uses the storeRelease method in the ReleaseSvcImpl class to store the object
	 * @param release The release to be persisted
	 * @return boolean true/false
	 * @throws ReleaseException 
	 */
	public boolean storeRelease(Release release) throws ReleaseException;
	/**
	 * Retrieves a Release
	 * @param Release The unique release for the Release to be retrieved
	 * @return The Release object matching release
	 * @throws ClassNotFoundException 
	 * @throws ReleaseException 
	 */
	public Set<Release> getRelease() throws ReleaseException, ClassNotFoundException;
}
