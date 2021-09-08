import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Demonstrates how to create a custom data structure, and the dangers of
 * returning references of this data structure. As a result, this object is not
 * encapsulated properly, and is not hiding its internal data properly (even
 * though it is set to private).
 *
 * @author CS 272 Software Development (University of San Francisco)
 * @version Fall 2021
 */
public class PrefixMap {
	/**
	 * Stores strings by the prefix they start with. The key is the prefix String
	 * and the value is a sorted set of strings that start with that prefix.
	 */
	private final TreeMap<String, TreeSet<String>> internal;

	/**
	 * Determines the size of the prefix used. Must be at least one letter. If a
	 * string is smaller than the prefix size, it is skipped. Since the value cannot
	 * be changed after initialization, it can be safely made public.
	 */
	public final int prefixSize;

	/**
	 * Initializes the prefix map using the specified size. If an invalid size is
	 * provided, will initialize a prefix map of size 1.
	 *
	 * @param prefixSize an integer value of 1 or greater for the size
	 */
	public PrefixMap(int prefixSize) {
		// Initialize the size of the prefix, defaulting to 1 if an invalid
		// value is provided.
		this.prefixSize = prefixSize < 1 ? 1 : prefixSize;

		/*
		 * Remember, this initializes the OUTER data structure only. You need a specific
		 * key to pair with the TreeSet before you can initialize the inner data
		 * structure.
		 */
		internal = new TreeMap<String, TreeSet<String>>();
	}

	/**
	 * Initializes a prefix map with a default size of 1.
	 *
	 * @see #PrefixMap(int)
	 */
	public PrefixMap() {
		this(1);
	}

	/**
	 * Adds a word to this prefix map.
	 *
	 * @param word the word to add
	 * @return {@code true} if the word was added
	 */
	public boolean addWord(String word) {
		// Make sure we have a non-null word with at least as many characters
		// as the prefix size.
		if (word == null || word.length() < prefixSize) {
			return false;
		}

		String prefix = word.substring(0, prefixSize);
		internal.putIfAbsent(prefix, new TreeSet<>());
		return internal.get(prefix).add(word);
	}

	/**
	 * Convenience method to add multiple words at once.
	 *
	 * @param words the words to add
	 * @see #addWord(String)
	 */
	public void addWords(String[] words) {
		for (String word : words) {
			addWord(word); // code reuse!
		}
	}

	/**
	 * Returns whether a prefix exists in internal data structure.
	 *
	 * @param prefix the prefix to search for
	 * @return {@code true} if prefix in map
	 */
	public boolean hasPrefix(String prefix) {
		return internal.containsKey(prefix);
	}

	// Converts entire internal data structure into a string representation
	@Override
	public String toString() {
		return internal.toString();
	}

	/**
	 * Unsafe method returning reference to internal data structure.
	 *
	 * @return reference to mutable internal map
	 */
	public TreeMap<String, TreeSet<String>> getMap() {
		return internal;
	}

	/**
	 * Unsafe method returning reference to internal keyset.
	 *
	 * @return reference to mutable keyset
	 */
	public Set<String> getPrefixes() {
		return internal.keySet();
	}

	/**
	 * Unsafe method returning reference to internal nested data structure.
	 *
	 * @param prefix the prefix to get
	 * @return reference to the mutable set of words with that prefix
	 */
	public Set<String> getWords(String prefix) {
		return internal.get(prefix);
	}

	/**
	 * Returns a safe copy of the prefixes in the map. The copy is not updated if
	 * this prefix map changes.
	 *
	 * @return copy of the prefixes in map
	 */
	public Set<String> copyPrefixes() {
		return new TreeSet<String>(internal.keySet());
	}

	/**
	 * Returns a safe copy of the words sharing a prefix. The copy is not updated if
	 * this prefix map changes.
	 *
	 * @param prefix the prefix to get
	 * @return a copy of the words with that prefix
	 */
	public Set<String> copyWords(String prefix) {
		TreeSet<String> words = internal.get(prefix);

		if (words != null) {
			return new TreeSet<String>(words);
		}

		return Collections.emptySet();
	}

	// What would a copyMap() look like?
	// Make sure you copy both the map and the inner sets!

	/**
	 * Returns an unmodifiable view of the prefixes stored in this map.
	 *
	 * @return unmodifiable view of the prefixes
	 */
	public Set<String> getUnmodifiablePrefixes() {
		return Collections.unmodifiableSet(internal.keySet());
	}

	/**
	 * Returns an unmodifiable view of the words for a given prefix.
	 *
	 * @param prefix the prefix to get
	 * @return unmodifiable view of the words for that prefix
	 */
	public Set<String> getUnmodifiableWords(String prefix) {
		if (internal.containsKey(prefix)) {
			return Collections.unmodifiableSet(internal.get(prefix));
		}

		return Collections.emptySet();
	}

	/**
	 * Returns an unmodifiable view of the internal map, but the internal data
	 * structures are still modifiable.
	 *
	 * @return unmodifiable view of the internal map
	 */
	public Map<String, TreeSet<String>> getUnmodifiableMap() {
		return Collections.unmodifiableMap(internal);
	}
}
