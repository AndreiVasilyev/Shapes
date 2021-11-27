package by.epam.jwdshape.repository.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.repository.Repository;
import by.epam.jwdshape.repository.Specification;

public class RepositoryImpl implements Repository {

	private static Repository instance;
	private List<Cone> cones;

	private RepositoryImpl() {
		cones = new ArrayList<>();
	}

	public static Repository getInstance() {
		if (instance == null) {
			instance = new RepositoryImpl();
		}
		return instance;
	}

	@Override
	public List<Cone> get() {
		return List.copyOf(cones);
	}

	@Override
	public boolean add(Cone cone) {
		return cones.add(cone);
	}

	@Override
	public boolean addAll(Collection<Cone> sourceCones) {
		return cones.addAll(sourceCones);
	}

	@Override
	public boolean remove(Cone cone) {
		return cones.remove(cone);
	}

	@Override
	public boolean removeAll(Collection<Cone> sourceCones) {
		return cones.removeAll(sourceCones);
	}

	@Override
	public Cone get(int index) {
		return cones.get(index);
	}
	
	@Override
	public void clear() {
		cones.clear();
	}

	@Override
	public Cone set(int index, Cone cone) {
		return cones.set(index, cone);
	}

	@Override
	public List<Cone> query(Specification specification) {
		return cones.stream().filter(specification).toList();
	}

	@Override
	public List<Cone> sort(Comparator<? super Cone> comparator) {
		return cones.stream().sorted(comparator).toList();
	}

	

}
