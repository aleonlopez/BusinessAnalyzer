# Business Analyzer
BusinessAnalyzer.java summarizes the data and information of the businesses in San Francisco. There are multiple sumaries that the user can search for: a zip code summary, a NAICS code summary, or a total summary. The zip code summary returns the total businesses in the zip code area, the amount of different business types, and the amount of neighborhoods that are in the zip code. The NAICS code summary returns the total businesses in the code area, the amount of zip codes in the code range, and the amount of neighborhoods that are in the code range. The data used was of Registered Business Locations - San Francisco found on the SFGov website: https://data.sfgov.org/Economy-and-Community/Registered-Business-Locations-San-Francisco/g8m3-pdis. 

#Complexity Analysis
** List Interface: ArrayList and LinkedList Functions

** ArrayList Functions

** get(int pos):

Time: O(1)

Space: O(1)

** add(T item):

Time: Ammortized O(1)

Space: O(1)

** add(int pos, T item):

Time: Ammortized O(n), n = size - pos

Space: O(1)

** remove(int pos):

Time: O(n), n = size - pos

Space: O(1)

** size()

Time: O(1)

Space: O(1)

** LinkedList Functions

** get(int pos):

Time: O(n), n is place in the list

Space: O(1)

** add(T item):

Time: O(1)

Space: O(1)

** add(int pos, T item):

Time: O(n), n = size - pos

Space: O(1)

** remove(int pos):

Time: O(n), n = size - pos

Space: O(1)

** size():

Time: O(1)

Space: O(1)

** Iterator Interface: ListIterator

** ListIterator Functions

** hasNext():

Time: O(1)

Space: O(1)

** next():

Time: O(1)

Space: O(1)
