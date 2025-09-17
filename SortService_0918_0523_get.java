// 代码生成时间: 2025-09-18 05:23:32
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SortService component that encapsulates sorting functionality.
 */
@Service
public class SortService {

    /**
     * Sorts integers using the Bubble Sort algorithm.
     *
     * @param numbers List of integers to be sorted.
     * @return List of sorted integers.
     * @throws IllegalArgumentException if the input list is null or empty.
     */
    public List<Integer> bubbleSort(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Input list cannot be null or empty.");
        }

        // Bubble Sort implementation
        int n = numbers.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
        return numbers;
    }

    /**
     * Sorts integers using the Java Stream API.
     *
     * @param numbers List of integers to be sorted.
     * @return List of sorted integers.
     * @throws IllegalArgumentException if the input list is null or empty.
     */
    public List<Integer> streamSort(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Input list cannot be null or empty.");
        }

        // Using Java Stream API to sort the list
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Sorts integers using a custom Comparator.
     *
     * @param numbers List of integers to be sorted.
     * @param comparator Custom comparator to define the sort order.
     * @return List of sorted integers based on the provided comparator.
     * @throws IllegalArgumentException if the input list is null or empty.
     */
    public List<Integer> customSort(List<Integer> numbers, Comparator<Integer> comparator) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Input list cannot be null or empty.");
        }

        // Custom sorting using a Comparator
        return numbers.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
