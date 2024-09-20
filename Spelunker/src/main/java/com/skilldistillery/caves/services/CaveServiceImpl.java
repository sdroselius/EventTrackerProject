package com.skilldistillery.caves.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.caves.entities.Cave;
import com.skilldistillery.caves.repositories.CaveRepository;

@Service
public class CaveServiceImpl implements CaveService {
	
	@Autowired
	private CaveRepository caveRepo;

	@Override
	public List<Cave> getAllCaves() {
		return caveRepo.findByEnabledTrue();
	}

	@Override
	public Cave showCave(int caveId) {
		return caveRepo.findByIdAndEnabledTrue(caveId);
	}

	@Override
	public Cave create(Cave newCave) {
		newCave.setEnabled(true);
		return caveRepo.saveAndFlush(newCave);
	}

	@Override
	public Cave update(int caveId, Cave updatingCave) {
		Cave existing = caveRepo.findByIdAndEnabledTrue(caveId);
		if (existing != null) {
			existing.setDescription(updatingCave.getDescription());
			existing.setEntranceAuthority(updatingCave.getEntranceAuthority());
			existing.setExploredLengthKm(updatingCave.getExploredLengthKm());
			existing.setImageUrl(updatingCave.getImageUrl());
			existing.setName(updatingCave.getName());
			existing.setOpenToPublic(updatingCave.getOpenToPublic());
			return caveRepo.saveAndFlush(existing);
		}
		return null;
	}

	@Override
	public boolean delete(int caveId) {
		boolean deleted = false;
		return deleted;
	}

}
