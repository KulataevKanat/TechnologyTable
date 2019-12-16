package kg.CSoft.TechnologyTable.util;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public interface Specifications {
    static <T> Specification<T> not(Specification<T> specification) {
        if (specification == null) return Specifications.specification();
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Predicate res = specification.toPredicate(root, query, builder);
            return res != null ? res.not() : null;
        };
    }

    static <T> Specification<T> and(Specification<T>... specifications) {
        return Specifications.and(Arrays.asList(specifications), false);
    }

    static <T> Specification<T> notAnd(Specification<T>... specifications) {
        return Specifications.and(Arrays.asList(specifications), true);
    }

    static <T> Specification<T> and(Iterable<Specification<T>> specifications) {
        return Specifications.and(specifications, false);
    }

    static <T> Specification<T> and(Iterable<Specification<T>> specifications, boolean isNot) {
        if (specifications == null) return Specifications.specification(isNot);
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Predicate res = null;
            for (Specification<T> specification : specifications) {
                if (res == null) {
                    res = specification.toPredicate(root, query, builder);
                } else {
                    Predicate other = specification.toPredicate(root, query, builder);
                    if (other != null) {
                        res = builder.and(res, other);
                    }
                }
            }
            return isNot && res != null ? res.not() : res;
        };
    }


    static <T> Specification<T> or(Specification<T>... specifications) {
        return Specifications.or(Arrays.asList(specifications), false);
    }

    static <T> Specification<T> notOr(Specification<T>... specifications) {
        return Specifications.or(Arrays.asList(specifications), true);
    }

    static <T> Specification<T> or(Iterable<Specification<T>> specifications) {
        return Specifications.or(specifications, false);
    }

    static <T> Specification<T> or(Iterable<Specification<T>> specifications, boolean isNot) {
        if (specifications == null) return Specifications.specification(isNot);
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Predicate res = null;
            for (Specification<T> specification : specifications) {
                if (res == null) {
                    res = specification.toPredicate(root, query, builder);
                } else {
                    Predicate other = specification.toPredicate(root, query, builder);
                    if (other != null) {
                        res = builder.or(res, other);
                    }
                }
            }
            return isNot && res != null ? res.not() : res;
        };
    }

    static <T> Specification<T> distinct() {
        return Specifications.distinct(false);
    }

    static <T> Specification<T> distinct(Class<T> tClass) {
        return Specifications.distinct(false);
    }

    static <T> Specification<T> distinct(boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            query.distinct(!isNot);
            return null;
        };
    }

    static <T> Specification<T> distinct(boolean isNot, Class<T> tClass) {
        return Specifications.distinct(isNot);
    }

    static <T> Specification<T> specification() {
        return Specifications.specification(false);
    }

    static <T> Specification<T> specification(Class<T> tClass) {
        return Specifications.specification(false);
    }

    static <T> Specification<T> specification(boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> null;
    }

    static <T> Specification<T> specification(boolean isNot, Class<T> tClass) {
        return Specifications.specification(isNot);
    }

    static <T> Specification<T> isNull(String field) {
        return Specifications.isNull(field, false);
    }

    static <T> Specification<T> isNull(String field, Class<T> tClass) {
        return Specifications.isNull(field, false);
    }

    static <T> Specification<T> isNull(String field, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Expression<?> expression = root.get(field);
            return isNot ? expression.isNotNull() : expression.isNull();
        };
    }

    static <T, E> Specification<T> isNull(String field, boolean isNot, Class<T> tClass) {
        return Specifications.isNull(field, isNot);
    }

    static <T, E> Specification<T> equal(String field, E value) {
        return Specifications.equal(field, value, false);
    }

    static <T, E> Specification<T> equal(String field, E value, Class<T> tClass) {
        return Specifications.equal(field, value, false);
    }

    static <T, E> Specification<T> equal(String field, E value, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Expression<E> expression = root.get(field);
            if (value == null) {
                return isNot ? expression.isNotNull() : expression.isNull();
            }
            return isNot ? builder.notEqual(expression, value) : builder.equal(expression, value);
        };
    }

    static <T, E> Specification<T> equal(String field, E value, boolean isNot, Class<T> tClass) {
        return Specifications.equal(field, value, isNot);
    }

    static <T> Specification<T> equal(String field, boolean value) {
        return Specifications.equal(field, value, false);
    }

    static <T> Specification<T> equal(String field, boolean value, Class<T> tClass) {
        return Specifications.equal(field, value, false);
    }

    static <T> Specification<T> equal(String field, boolean value, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Expression<Boolean> expression = root.get(field);
            return isNot
                    ? (value ? builder.isFalse(expression) : builder.isTrue(expression))
                    : (value ? builder.isTrue(expression) : builder.isFalse(expression));
        };
    }

    static <T> Specification<T> equal(String field, boolean value, boolean isNot, Class<T> tClass) {
        return Specifications.equal(field, value, isNot);
    }

    static <T> Specification<T> containsIgnoreCase(String field, String value) {
        return Specifications.containsIgnoreCase(field, value, false);
    }

    static <T> Specification<T> containsIgnoreCase(String field, String value, Class<T> tClass) {
        return Specifications.containsIgnoreCase(field, value, false);
    }

    static <T> Specification<T> containsIgnoreCase(String field, String value, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Expression<String> expression = builder.upper(root.get(field));
            String pattern = ('%' + value + '%').toUpperCase();
            return isNot ? builder.notLike(expression, pattern) : builder.like(expression, pattern);
        };
    }

    static <T> Specification<T> containsIgnoreCase(String field, String value, boolean isNot, Class<T> tClass) {
        return Specifications.containsIgnoreCase(field, value, isNot);
    }

    static <T> Specification<T> startingWithIgnoreCase(String field, String value) {
        return Specifications.startingWithIgnoreCase(field, value, false);
    }

    static <T> Specification<T> startingWithIgnoreCase(String field, String value, Class<T> tClass) {
        return Specifications.startingWithIgnoreCase(field, value, false);
    }

    static <T> Specification<T> startingWithIgnoreCase(String field, String value, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Expression<String> expression = builder.upper(root.get(field));
            String pattern = ('%' + value).toUpperCase();
            return isNot ? builder.notLike(expression, pattern) : builder.like(expression, pattern);
        };
    }

    static <T> Specification<T> startingWithIgnoreCase(String field, String value, boolean isNot, Class<T> tClass) {
        return Specifications.startingWithIgnoreCase(field, value, isNot);
    }

    static <T, E> Specification<T> in(String field, Collection<E> values) {
        return Specifications.in(field, values, false);
    }

    static <T, E> Specification<T> in(String field, Collection<E> values, Class<T> tClass) {
        return Specifications.in(field, values, false);
    }

    static <T, E> Specification<T> in(String field, Collection<E> values, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Predicate predicate = root.get(field).in(values);
            return isNot ? builder.not(predicate) : predicate;
        };
    }

    static <T, E> Specification<T> in(String field, Collection<E> values, boolean isNot, Class<T> tClass) {
        return Specifications.in(field, values, isNot);
    }

    static <T, E extends Comparable<? super E>> Specification<T> between(String field, E left, E right) {
        return Specifications.between(field, left, right, false);
    }

    static <T, E extends Comparable<? super E>> Specification<T> between(String field, E left, E right, Class<T> tClass) {
        return Specifications.between(field, left, right, false);
    }

    static <T, E extends Comparable<? super E>> Specification<T> between(String field, E left, E right, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Predicate predicate;
            if (left != null && right != null) {
                predicate = builder.between(root.get(field), left, right);
            } else if (left != null) {
                predicate = builder.greaterThanOrEqualTo(root.get(field), left);
            } else if (right != null) {
                predicate = builder.lessThanOrEqualTo(root.get(field), right);
            } else {
                return null;
            }
            return isNot ? builder.not(predicate) : predicate;
        };
    }

    static <T, E extends Comparable<? super E>> Specification<T> between(String field, E left, E right, boolean isNot, Class<T> tClass) {
        return Specifications.between(field, left, right, isNot);
    }

    static <T, E extends Comparable<? super E>> Specification<T> less(String field, E value) {
        return Specifications.less(field, value, false);
    }

    static <T, E extends Comparable<? super E>> Specification<T> less(String field, E value, Class<T> tClass) {
        return Specifications.less(field, value, false);
    }

    static <T, E extends Comparable<? super E>> Specification<T> less(String field, E value, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Predicate predicate = builder.lessThan(root.get(field), value);
            return isNot ? builder.not(predicate) : predicate;
        };
    }

    static <T, E extends Comparable<? super E>> Specification<T> less(String field, E value, boolean isNot, Class<T> tClass) {
        return Specifications.less(field, value, isNot);
    }

    static <T, E extends Comparable<? super E>> Specification<T> greater(String field, E value) {
        return Specifications.greater(field, value, false);
    }

    static <T, E extends Comparable<? super E>> Specification<T> greater(String field, E value, Class<T> tClass) {
        return Specifications.greater(field, value, false);
    }

    static <T, E extends Comparable<? super E>> Specification<T> greater(String field, E value, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Predicate predicate = builder.greaterThan(root.get(field), value);
            return isNot ? builder.not(predicate) : predicate;
        };
    }

    static <T, E extends Comparable<? super E>> Specification<T> greater(String field, E value, boolean isNot, Class<T> tClass) {
        return Specifications.greater(field, value, isNot);
    }

    static <T, E> Specification<T> join_equal(String join, String field, E value) {
        return Specifications.join_equal(join, field, value, false);
    }

    static <T, E> Specification<T> join_equal(String join, String field, E value, Class<T> tClass) {
        return Specifications.join_equal(join, field, value, false);
    }

    static <T, E> Specification<T> join_equal(String join, String field, E value, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Expression<E> expression = field == null ? root.join(join) : root.join(join).get(field);
            if (value == null) {
                return isNot ? expression.isNotNull() : expression.isNull();
            }
            return isNot ? builder.notEqual(expression, value) : builder.equal(expression, value);
        };
    }

    static <T, E> Specification<T> join_equal(String join, String field, E value, boolean isNot, Class<T> tClass) {
        return Specifications.join_equal(join, field, value, isNot);
    }

    static <T, E> Specification<T> join_in(String join, String field, Collection<E> values) {
        return Specifications.join_in(join, field, values, false);
    }

    static <T, E> Specification<T> join_in(String join, String field, Collection<E> values, Class<T> tClass) {
        return Specifications.join_in(join, field, values, false);
    }

    static <T, U, E> Specification<T> join_in(String join, String field, Collection<E> values, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Expression<E> expression = field == null ? root.join(join) : root.join(join).get(field);
            Predicate predicate = expression.in(values);
            return isNot ? builder.not(predicate) : predicate;
        };
    }

    static <T, E> Specification<T> join_in(String join, String field, Collection<E> values, boolean isNot, Class<T> tClass) {
        return Specifications.join_in(join, field, values, isNot);
    }

    static <T, E extends Comparable<? super E>> Specification<T> join_less(String join, String field, E value) {
        return Specifications.join_less(join, field, value, false);
    }

    static <T, E extends Comparable<? super E>> Specification<T> join_less(String join, String field, E value, Class<T> tClass) {
        return Specifications.join_less(join, field, value, false);
    }

    static <T, E extends Comparable<? super E>> Specification<T> join_less(String join, String field, E value, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Expression<E> expression = field == null ? root.join(join) : root.join(join).get(field);
            Predicate predicate = builder.lessThan(expression, value);
            return isNot ? builder.not(predicate) : predicate;
        };
    }

    static <T, E extends Comparable<? super E>> Specification<T> join_less(String join, String field, E value, boolean isNot, Class<T> tClass) {
        return Specifications.join_less(join, field, value, isNot);
    }

    static <T, E extends Comparable<? super E>> Specification<T> join_greater(String join, String field, E value) {
        return Specifications.join_greater(join, field, value, false);
    }

    static <T, E extends Comparable<? super E>> Specification<T> join_greater(String join, String field, E value, Class<T> tClass) {
        return Specifications.join_greater(join, field, value, false);
    }

    static <T, E extends Comparable<? super E>> Specification<T> join_greater(String join, String field, E value, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Expression<E> expression = field == null ? root.join(join) : root.join(join).get(field);
            Predicate predicate = builder.greaterThan(expression, value);
            return isNot ? builder.not(predicate) : predicate;
        };
    }

    static <T, E extends Comparable<? super E>> Specification<T> join_greater(String join, String field, E value, boolean isNot, Class<T> tClass) {
        return Specifications.join_greater(join, field, value, isNot);
    }

    class Property {
        private final String field;
        private final Property join;

        private Property(String field, Property join) {
            this.field = field;
            this.join = join;
        }

        public String getField() {
            return field;
        }

        public Property getJoin() {
            return join;
        }

        public Property join(String field) {
            return new Property(field, this);
        }

        public static Property of(String field) {
            return new Property(field, null);
        }

        public static Property of(String field1, String... fields) {
            Property property = of(field1);
            for (String field : fields) {
                property = property.join(field);
            }
            return property;
        }

        public <Y> Expression<Y> get(Root<?> root) {
            return join == null ? root.get(field) : join.join(root).get(field);
        }

        private <Z, X> Join<Z, X> join(Root<?> root) {
            return join == null ? root.join(field) : join.join(root).join(field);
        }
    }

    static <T> Specification<T> isNull(Property field) {
        return Specifications.isNull(field, false);
    }

    static <T> Specification<T> isNull(Property field, Class<T> tClass) {
        return Specifications.isNull(field, false);
    }

    static <T> Specification<T> isNull(Property field, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Expression<?> expression = field.get(root);
            return isNot ? expression.isNotNull() : expression.isNull();
        };
    }

    static <T> Specification<T> isNull(Property field, boolean isNot, Class<T> tClass) {
        return Specifications.isNull(field, isNot);
    }

    static <T, E> Specification<T> equal(Property field, E value) {
        return Specifications.equal(field, value, false);
    }

    static <T, E> Specification<T> equal(Property field, E value, Class<T> tClass) {
        return Specifications.equal(field, value, false);
    }

    static <T, E> Specification<T> equal(Property field, E value, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Expression<E> expression = field.get(root);
            if (value == null) {
                return isNot ? expression.isNotNull() : expression.isNull();
            }
            return isNot ? builder.notEqual(expression, value) : builder.equal(expression, value);
        };
    }

    static <T, E> Specification<T> equal(Property field, E value, boolean isNot, Class<T> tClass) {
        return Specifications.equal(field, value, isNot);
    }

    static <T> Specification<T> equal(Property field, boolean value) {
        return Specifications.equal(field, value, false);
    }

    static <T> Specification<T> equal(Property field, boolean value, Class<T> tClass) {
        return Specifications.equal(field, value, false);
    }

    static <T> Specification<T> equal(Property field, boolean value, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Expression<Boolean> expression = field.get(root);
            return isNot
                    ? (value ? builder.isFalse(expression) : builder.isTrue(expression))
                    : (value ? builder.isTrue(expression) : builder.isFalse(expression));
        };
    }

    static <T> Specification<T> equal(Property field, boolean value, boolean isNot, Class<T> tClass) {
        return Specifications.equal(field, value, isNot);
    }

    static <T> Specification<T> containsIgnoreCase(Property field, String value) {
        return Specifications.containsIgnoreCase(field, value, false);
    }

    static <T> Specification<T> containsIgnoreCase(Property field, String value, Class<T> tClass) {
        return Specifications.containsIgnoreCase(field, value, false);
    }

    static <T> Specification<T> containsIgnoreCase(Property field, String value, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Expression<String> expression = builder.upper(field.get(root));
            String pattern = ('%' + value + '%').toUpperCase();
            return isNot ? builder.notLike(expression, pattern) : builder.like(expression, pattern);
        };
    }

    static <T> Specification<T> containsIgnoreCase(Property field, String value, boolean isNot, Class<T> tClass) {
        return Specifications.containsIgnoreCase(field, value, isNot);
    }

    static <T> Specification<T> startingWithIgnoreCase(Property field, String value) {
        return Specifications.startingWithIgnoreCase(field, value, false);
    }

    static <T> Specification<T> startingWithIgnoreCase(Property field, String value, Class<T> tClass) {
        return Specifications.startingWithIgnoreCase(field, value, false);
    }

    static <T> Specification<T> startingWithIgnoreCase(Property field, String value, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Expression<String> expression = builder.upper(field.get(root));
            String pattern = ('%' + value).toUpperCase();
            return isNot ? builder.notLike(expression, pattern) : builder.like(expression, pattern);
        };
    }

    static <T> Specification<T> startingWithIgnoreCase(Property field, String value, boolean isNot, Class<T> tClass) {
        return Specifications.startingWithIgnoreCase(field, value, isNot);
    }

    static <T, E> Specification<T> in(Property field, Collection<E> values) {
        return Specifications.in(field, values, false);
    }

    static <T, E> Specification<T> in(Property field, Collection<E> values, Class<T> tClass) {
        return Specifications.in(field, values, false);
    }

    static <T, E> Specification<T> in(Property field, Collection<E> values, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Predicate predicate = field.get(root).in(values);
            return isNot ? builder.not(predicate) : predicate;
        };
    }

    static <T, E> Specification<T> in(Property field, Collection<E> values, boolean isNot, Class<T> tClass) {
        return Specifications.in(field, values, isNot);
    }

    static <T, E extends Comparable<? super E>> Specification<T> between(Property field, E left, E right) {
        return Specifications.between(field, left, right, false);
    }

    static <T, E extends Comparable<? super E>> Specification<T> between(Property field, E left, E right, Class<T> tClass) {
        return Specifications.between(field, left, right, false);
    }

    static <T, E extends Comparable<? super E>> Specification<T> between(Property field, E left, E right, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Predicate predicate;
            if (left != null && right != null) {
                predicate = builder.between(field.get(root), left, right);
            } else if (left != null) {
                predicate = builder.greaterThanOrEqualTo(field.get(root), left);
            } else if (right != null) {
                predicate = builder.lessThanOrEqualTo(field.get(root), right);
            } else {
                return null;
            }
            return isNot ? builder.not(predicate) : predicate;
        };
    }

    static <T, E extends Comparable<? super E>> Specification<T> between(Property field, E left, E right, boolean isNot, Class<T> tClass) {
        return Specifications.between(field, left, right, isNot);
    }

    static <T, E extends Comparable<? super E>> Specification<T> less(Property field, E value) {
        return Specifications.less(field, value, false);
    }

    static <T, E extends Comparable<? super E>> Specification<T> less(Property field, E value, Class<T> tClass) {
        return Specifications.less(field, value, false);
    }

    static <T, E extends Comparable<? super E>> Specification<T> less(Property field, E value, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Predicate predicate = builder.lessThan(field.get(root), value);
            return isNot ? builder.not(predicate) : predicate;
        };
    }

    static <T, E extends Comparable<? super E>> Specification<T> less(Property field, E value, boolean isNot, Class<T> tClass) {
        return Specifications.less(field, value, isNot);
    }

    static <T, E extends Comparable<? super E>> Specification<T> greater(Property field, E value) {
        return Specifications.greater(field, value, false);
    }

    static <T, E extends Comparable<? super E>> Specification<T> greater(Property field, E value, Class<T> tClass) {
        return Specifications.greater(field, value, false);
    }

    static <T, E extends Comparable<? super E>> Specification<T> greater(Property field, E value, boolean isNot) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Predicate predicate = builder.greaterThan(field.get(root), value);
            return isNot ? builder.not(predicate) : predicate;
        };
    }

    class Order {
        private final boolean ascending;
        private final Property property;
        private final Object nullDefault;

        private Order(boolean ascending, Property property, Object nullDefault) {
            this.ascending = ascending;
            this.property = property;
            this.nullDefault = nullDefault;
        }

        public boolean isAscending() {
            return ascending;
        }

        public Property getProperty() {
            return property;
        }

        public Object getNullDefault() {
            return nullDefault;
        }

        public static Order asc(String property) {
            return new Order(true, Property.of(property), null);
        }

        public static Order asc(Property property) {
            return new Order(true, property, null);
        }

        public static Order desc(String property) {
            return new Order(false, Property.of(property), null);
        }

        public static Order desc(Property property) {
            return new Order(false, property, null);
        }

        public static Order asc(String property, Object nullDefault) {
            return new Order(true, Property.of(property), nullDefault);
        }

        public static Order asc(Property property, Object nullDefault) {
            return new Order(true, property, nullDefault);
        }

        public static Order desc(String property, Object nullDefault) {
            return new Order(false, Property.of(property), nullDefault);
        }

        public static Order desc(Property property, Object nullDefault) {
            return new Order(false, property, nullDefault);
        }

        public javax.persistence.criteria.Order toOrder(Root<?> root, CriteriaBuilder builder) {
            Expression<?> expression = nullDefault == null ? property.get(root) : builder.coalesce(property.get(root), nullDefault);
            return ascending ? builder.asc(expression) : builder.desc(expression);
        }
    }

    static <T> Specification<T> sort(Order... orders) {
        return Specifications.sort(Arrays.asList(orders));
    }

    static <T> Specification<T> sort(Order order, Class<T> tClass) {
        return Specifications.sort(Arrays.asList(order));
    }

    static <T> Specification<T> sort(List<Order> orders) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            List<javax.persistence.criteria.Order> criteriaOrders = new ArrayList<>(orders.size());
            orders.forEach(order -> criteriaOrders.add(order.toOrder(root, builder)));
            query.orderBy(criteriaOrders);
            return null;
        };
    }

    static <T> Specification<T> sort(List<Order> orders, Class<T> tClass) {
        return Specifications.sort(orders);
    }


}

