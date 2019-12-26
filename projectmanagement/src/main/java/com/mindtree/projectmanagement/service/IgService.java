package com.mindtree.projectmanagement.service;

import com.mindtree.projectmanagement.dto.IgDto;
import com.mindtree.projectmanagement.entity.Ig;
import com.mindtree.projectmanagement.exception.ServiceException;

public interface IgService {

	public IgDto insertIG(Ig ig) throws ServiceException;


}
