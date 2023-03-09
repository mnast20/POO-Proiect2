# POO-Proiect2

The program manages Santa's Database containing the children's information and all available gifts, as well as Santa's budget for that year. When the new year comes, the Database needs to be updated because the children age and sometimes their gift preferences can shift. Another yearly change could be Santa's budget or an update on the gifts list. Every year, Santa needs to deliver presents to the children aged 0 - 18, being able to only spend as much money as the child's assigned budget requires. He will also receive help from the elves of each child, who are able to change a child's budget or offer a new gift to the child based on the elf type.

## Input classes:
### Input:
Class storing the number of years, the initial data, Santa's budget for the first year, or Round 0 and a list of annual changes.

### InitialData:
Class holding the initial children and gifts list that will be used for Round 0.

### AnnualChange:
Class storing yearly updates, such as possible new children, new gifts, Santa's new budget, as well as updates for children that already are present in the Database.

### ChildUpdate:
Represents a possible update for a child and it stores an id that will be used to search the child in the Database. Depending on the update, the found child's Gift Preference list could have new Categories added to it, or the child could receive a new nice score or a different elf.

### ChildInput:
Class holding the initial information for a child, such as his id, his firstname and lastname, his age, the city he lives in, his initial nice score, his elf, as well as a Gifts Preferences list with the Categories that he is most interested in. Besides these mandatory properties, a child can sometimes receive a nice score bonus. Thus, the child will be built using a builder pattern, because the bonus nice score is optional.

### GiftInput:
Class storing present's data; its price, its category, its quantity and its name.

## Database class:
### SantaDatabase:
Database instantiated as Lazy Singleton keeping a list of all children and a list of all gifts and recording the number of years that will pass, as well as Santa's budget and the budget unit for the current year. The list of children and gifts from the Input will be transferred to the Database and the children will be declared as Baby, Kid or Teen (adults will be removed) based on their ages in order to properly calculate their average nice score grade. Once every child was attributed an average grade, the sum of all average grades is computed and by dividing Santa's budget by the sum, then the budget per unit will be determined. After, the children list will be once again iterated in order to get the value of every child's assigned budget. After all gifts are distributed and the list of children is added to the output, the children's list of received gifts is cleared for the next year to come.

## Child Classes:
### Child:
Class storing a child's id, firstname, lastname, age, city, elf, nice score bonus, a list of gift preferences, as well as a list of nice scores history, an assigned budget and a list of received gifts. The assigned budget obtained by dividing the Database's budget unit by the child's average score If the child is assigned a pink or black elf, his assigned budget will be modified. On the other hand, the average nice score will be calculated using a Visitor Pattern based on the age category that child fits in, which will be discussed below.

### Baby:
Class extending the Child class and representing a child aged 0 - 5. For this type of age group, the average score will always be maximum, a 10.

### Kid:
Class extending the Child class and representing a child aged 5 - 12. For this type of age group, the average score will be equal with the arithmetic average of the nice score history list.

### Teen:
Class extending the Child class and representing a child aged 12 - 18. For this type of age group, the average score will be equal with the weighted average of the nice score history list.

### ChildVisitor:
Class implementing a Visitor interface that is used in order to calculate every type of child's average score based on their respective methods. For every child, after his average score is calculated, the nice score bonus will be added and if the new score exceeds 10, the score will remain equal to 10.

### ChildUtil:
Class containing a method for applying the yellow elves strategy to a given list of children, a method for searching a child in Database based on a given city, a method for searching a child in Database based on a given id, a method for aging all children inside the Database and putting them in their respective age groups, a method for removing all adults from the Santa's Database and a method for calculating the assigned budgets for all the children in the Database.

## Elf Classes:
### BlackElfStrategy:
Class applying the black elf's function, which is to decrease a child's budget with 30%.

### PinkElfStrategy:
Class applying the pink elf's function, which is to increase a child's budget with 30%.

### YellowElfStrategy:
Class applying the yellow elf's function, which is to offer the child a new gift if he hasn't received any gifts. However, a few conditions should be met, meaning only the gift with the lowest price inside the child's favourite category can be received, only if it is still in stock.

### WhiteElfStrategy:
Class applying the white elf's function, meaning nothing.

### ElfFactory:
Factory pattern that creates the elf strategy based on a given type of elf.

## Gift Classes:
### Gift:
Class storing present's data; its price, its category, its quantity and its name.

### GiftUtil:
Class including a method for finding a gift with the minimum price inside a given list of presents, a method for searching all gifts that fall in a required category, a method for delivering gifts to a child and another method for delivering gifts to all the children in the Database. In order to deliver gifts to a child, his list of gifts preferences is traversed and for every category, the lowest priced gift will be added to the child's list of received gifts until the assigned budget was spent. When a gift is distributed, its quantity decreases.

## Strategies for distributing gifts:
### IdStrategy:
The children in the Database will be sorted based on their IDs, and then the gifts will be distributed to every child in the order of their IDs.

### NiceScoreStrategy:
The children in the Database will be sorted based on their average nice scores and then the gifts will be distributed to the sorted list of children.

### NiceScoreCityStrategy:
The children in the Database will be sorted based on the cities' average nice scores and then the gifts will be distributed.

### DistributeStrategyFactory:
Factory creating the Distributing Strategy from a given string.

## Sort Classes:
### SortById:
Class containing a method sorting children by ID, but since the children are already sorted in the Database, then the children list will simply be returned.

### SortByNiceScore:
Class containing a method that orders the children in the Database based on their average score.

### SortByNiceScoreCity:
Class containing a method that orders the children in the Database based on the cities' average score. Two Hashmaps are created, one with the city as key and a list of people that live in the City as value, and the other one keep's the Cities' average scores. The cities are ordered based on their average nice score. After, by iterating through the sorted list of Cities, all the children living in the cities are put in order in a list.

## Year Class:
Class containing a method handling year changes. First, all the children age and the adults are removed from the Database. For every child update, the child is searched in the Database based on the id mentioned in the update. If he is found, a new nice score can be added to his list of nice score history, and/or the child's elf can be changed and/or his list of preferences will be updated, adding the new preferred categories at the start of the list. After, if need be, Santa's budget will be updated and new children and gifts are added to the Database. Then, the budget unit and the assigned budget are recalculated.

## Round class:
Class containing a method for solving all rounds and a method executing a single round. For every round, the gifts are distributed and then, the yellow elves are applied. If the round is different from Round0, the year changes are implemented before the gifts are distributed.

## AnnualChildren:
Class containing a list of children from a certain year.

## Output class:
Class containing a list of AnnualChildren for every year (0 to number of years).

## Main class:
In the main method, the Output directory and files will be created in case they don't exist. For every test, the Input will be extracted from the JSON input file and added to the Database. For every round (0 to number of years), the gifts will be delivered to everyone, then the annual children will be added to the output and the received gifts list will be wiped clean for the next round. After each test, the output is inserted in the output file and the Database will be cleared.
