package com.mindtree.projectmanagement.service.impl;

import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.projectmanagement.dto.IgDto;
import com.mindtree.projectmanagement.entity.Ig;
import com.mindtree.projectmanagement.exception.IgAlreadyExistsException;
import com.mindtree.projectmanagement.exception.ServiceException;
import com.mindtree.projectmanagement.exception.util.ErrorConstants;
import com.mindtree.projectmanagement.repository.AccountRepository;
import com.mindtree.projectmanagement.repository.IgRepository;
import com.mindtree.projectmanagement.repository.ProjectRepository;
import com.mindtree.projectmanagement.service.IgService;



@Service
public class IgServiceImpl implements IgService{

	@Autowired
	private IgRepository igRepo;
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private AccountRepository accountRepo;

	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public IgDto insertIG(Ig ig) throws ServiceException {
		// TODO Auto-generated method stub
		Ig existingIg  =null;
		
		List<Ig> existingIgList = igRepo.findAll();
		for (Ig ig2 : existingIgList) {
			if(ig2.getIgName().equalsIgnoreCase(ig.getIgName())) {
				existingIg= ig2;
				break;
			}
		}
		if(existingIg !=null) {
			throw new IgAlreadyExistsException(ErrorConstants.IGALREADYEXISTS);
		}
		else {
			igRepo.save(ig);
			return modelMapper.map(ig, IgDto.class);
			
			
		}
		
	}
	


}
