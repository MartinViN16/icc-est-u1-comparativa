import java.util.List;

public class Algoritmos {
    public void sortBubble(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int aux = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, aux);
                    swap = true;
                }
            }
            if (!swap) {
                return;
            }
        }
    }

    public void sortMerge(List<Integer> list) {
        if (list.size() < 2) {
            return;
        }
        int mid = list.size() / 2;
        List<Integer> left = list.subList(0, mid);
        List<Integer> right = list.subList(mid, list.size());
        sortMerge(left);
        sortMerge(right);
        merge(list, left, right);
    }
}
