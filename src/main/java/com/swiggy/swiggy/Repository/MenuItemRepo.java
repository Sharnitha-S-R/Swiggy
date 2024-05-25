package com.swiggy.swiggy.Repository;
import com.swiggy.swiggy.Entity.MenuItem;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.swiggy.swiggy.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {
    @Override
    default <S extends MenuItem> S save(S entity) {
        return null;
    }

    @Override
    default <S extends MenuItem> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    default Optional<MenuItem> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    List<MenuItem> findAll();

    @Override
    default List<MenuItem> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default void deleteById(Long aLong) {

    }

    @Override
    default void delete(MenuItem entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    default void deleteAll(Iterable<? extends MenuItem> entities) {

    }

    @Override
    default void deleteAll() {

    }

    List<MenuItem> findByItemNameContainingIgnoreCase(String itemName);
    List<MenuItem> findByPriceBetween(double minPrice, double maxPrice);
    List<MenuItem> findByCategoryIgnoreCase(String category);
    List<MenuItem> findByIngredientsContainingIgnoreCase(String ingredients);

    @Override
    default void flush() {

    }

    @Override
    default <S extends MenuItem> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    default <S extends MenuItem> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    default void deleteAllInBatch(Iterable<MenuItem> entities) {

    }

    @Override
    default void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    default void deleteAllInBatch() {

    }

    @Override
    default MenuItem getOne(Long aLong) {
        return null;
    }

    @Override
    default MenuItem getById(Long aLong) {
        return null;
    }

    @Override
    default MenuItem getReferenceById(Long aLong) {
        return null;
    }

    @Override
    default <S extends MenuItem> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    default <S extends MenuItem> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    default <S extends MenuItem> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    default <S extends MenuItem> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    default <S extends MenuItem> long count(Example<S> example) {
        return 0;
    }

    @Override
    default <S extends MenuItem> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    default <S extends MenuItem, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    default List<MenuItem> findAll(Sort sort) {
        return null;
    }

    @Override
    default Page<MenuItem> findAll(Pageable pageable) {
        return null;
    }
}
