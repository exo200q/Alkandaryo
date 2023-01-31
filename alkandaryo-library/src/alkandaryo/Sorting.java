package alkandaryo;

public interface Sorting<E> {
   interface Sortable {
      int hashCode();
   }

   static boolean hasImplementation(Object object) {
      for (Class<?> i : object.getClass().getInterfaces()) {
         if (i.getSimpleName().equals(Sortable.class.getSimpleName()))
            return true;
      }
      return false;
   }
}
