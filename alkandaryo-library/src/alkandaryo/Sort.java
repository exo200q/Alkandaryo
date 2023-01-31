package alkandaryo;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public final class Sort<E extends Sort.Sortable> extends AbstractList<E> {
   public interface Sortable {
      int getSortKey();
   }

   private final List<E> elements;
   private long order;

   public static final long ASCENDING  = -1L;
   public static final long DESCENDING = 1L;

   public Sort() {
      this.elements = new ArrayList<>();
   }

   public void setOrder(long order) {
      if   (Objects.equals(order, Sort.ASCENDING)
         || Objects.equals(order, Sort.DESCENDING)) {
         this.order = order;
      }
   }

   public long getOrder() {
      return order;
   }

   @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
   public List<E> toList() {
      HashMap<Integer, E> hashMap = new HashMap<>();
      List<E> lists;

      for (E _element : elements) hashMap.put(_element.getSortKey(), _element);
      var sorted = Objects.equals(order, Sort.ASCENDING)  ? hashMap.keySet().stream()
                 : Objects.equals(order, Sort.DESCENDING) ? hashMap.keySet().stream()
                          .sorted(Comparator.reverseOrder())
                 : null;
      if (Objects.isNull(sorted)) return elements;
      else lists = sorted.map(hashMap::get).collect(Collectors.toList());
      return lists;
   }

   @Override
   public Object[] toArray() {
      return toList().toArray();
   }

   @Override
   public boolean add(E element) {
      if (element == null) return false;
      return elements.add(element);
   }

   @Override
   public E remove(int index) {
      return elements.remove(index);
   }

   @Override
   public int size() {
      return elements.size();
   }

   @Override
   public E get(int index) {
      return elements.get(index);
   }

   @SuppressWarnings("unchecked")
   @Override
   public void forEach(Consumer<? super E> action) {
      Arrays.stream(toArray()).forEach((Consumer<? super Object>) action);
   }
}
