package by.epam.jwdshape.repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import by.epam.jwdshape.entity.Cone;

public interface Repository {

	public boolean add(Cone cone);

	public boolean addAll(Collection<Cone> cones);

	public boolean remove(Cone cone);

	public boolean removeAll(Collection<Cone> cones);

	public Cone get(int index);

	public Cone set(int index, Cone cone);

	public List<Cone> query(Specification specification);

	public List<Cone> sort(Comparator<? super Cone> comparator);
}
