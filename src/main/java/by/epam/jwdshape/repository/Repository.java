package by.epam.jwdshape.repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import by.epam.jwdshape.entity.Cone;

public interface Repository {

	boolean add(Cone cone);

	boolean addAll(Collection<Cone> cones);

	boolean remove(Cone cone);

	boolean removeAll(Collection<Cone> cones);

	Cone get(int index);

	Cone set(int index, Cone cone);

	List<Cone> query(Specification specification);

	List<Cone> sort(Comparator<? super Cone> comparator);

	List<Cone> get();

	void clear();
}
