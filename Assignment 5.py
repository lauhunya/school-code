

# The Property class holds general data about livings spaces that are
# for sale.

class Property:
    # The __init__ method accepts arguments for the address, price, number of rooms, 
    # size in square feet, and number of bathrooms, fireplace, and the pool.
    
    def __init__(self, address, price, sizeInSquareFeet,
                 numOfBathrooms, hasFireplace, hasPool):
        self.address = address
        self.price = price
      
        self.sizeInSquareFeet = sizeInSquareFeet
        self.numOfBathrooms = numOfBathrooms
        self.hasFireplace = hasFireplace
        self.hasPool = hasPool

    # The following methods are mutators for the
    # class's data attributes.
    
    def set_address(self, address):
        self.address = address

    def set_price(self, price):
        self.price = price

   # def set_numOfRooms(self, numOfRooms):
     #   self.numOfRooms = numOfRooms

    def set_sizeInSquareFeet(self, sizeInSquareFeet):
        self.sizeInSquareFeet = sizeInSquareFeet
    
    def set_numOfBathrooms(self, numOfBathrooms):
        self.numOfBathrooms = numOfBathrooms
    
    def set_hasFirplace(self, hasFireplace):
        self.hasFireplace = hasFireplace
    
    def set_hasPool(self, hasPool):
        self.hasPool= hasPool

    # The following methods are the accessors
    # for the class's data attributes.
    
    def get_address(self):
        return self.address

    def get_price(self):
        return self.price

 #   def get_numOfRooms(self):
     #   return self.numOfRooms

    def get_sizeInSquareFeet(self):
        return self.sizeInSquareFeet
    
    def get_numOfBathrooms(self):
        return self.numOfBathrooms
    
    def get_hasFireplace(self):
        return self.hasFireplace
    
    def get_hasPool(self):
        return self.hasPool

# The Condimnium class is a subclass of the Property class.

class Condiminium(Property):
    # The __init__ method accepts arguments for the address, price, number of rooms, 
    # size in square feet, and number of bathrooms, fireplace, pool, and the
    # floor number.
    
    def __init__(self, address, price, numOfRooms, sizeInSquareFeet,
                 numOfBathrooms, hasFireplace, hasPool, floorNum):
        # Calling the superclass's __init__ method and passing in
        # the necessary arguments. 
        Property.__init__(self, address, price, numOfRooms, sizeInSquareFeet,
                 numOfBathrooms, hasFireplace, hasPool)

        # Initialize the floorNum attribute.
        self.floorNum = floorNum

    # The set_floorNum method is the mutator for the
    # floorNum attribute.

    def set_floorNum(self, floorNum):
        self.floorNum = floorNum

    # The get_floorNum method is the accessor for the
    # floorNum attribute.

    def get_floorNum(self):
        return self.floorNum

# The TownHouse class is a subclass of the Property class.

class TownHouse(Property):
    # The __init__ method accepts arguments for the address, price, number of rooms, 
    # size in square feet, and number of bathrooms, fireplace, pool, and whether 
    # they are apart of a homeowner's association.
    
    def __init__(self, address, price, numOfRooms, sizeInSquareFeet,
                 numOfBathrooms, hasFireplace, hasPool, homeOwnerAssociation):
        # Calling the superclass's __init__ method and passing in
        # the necessary arguments.
        Property.__init__(self, address, price, numOfRooms, sizeInSquareFeet,
                 numOfBathrooms, hasFireplace, hasPool)
        
        # Initialize the homeOwnerAssociation attribute.
        self.homeOwnerAssociation = homeOwnerAssociation

    # The set_homeOwnerAssociation method is the mutator for the
    # homeOwnerAssociation attribute.

    def set_homeOwnerAssociation(self, homeOwnerAssociation):
        self.homeOwnerAssociation = homeOwnerAssociation

    # The get_homeOwnerAssociation method is the accessor for the
    # homeOwnerAssociation attribute.

    def get_homeOwnerAssociation(self):
        return self.homeOwnerAssociation

# The Family Home class is a subclass of the Property class.
class FamilyHome(Property):
    
    # The __init__ method accepts arguments for the
    # Family Home's address, price, number of rooms, size in square feet, and number
    # of bathrooms, fireplace, pool, and the amount of land.
    
    def __init__(self, address, price, numOfRooms, sizeInSquareFeet,
                 numOfBathrooms, hasFireplace, hasPool, landAmount):
        # Calling the superclass's __init__ method and passing
        # in the necessary arguments. 
        Property.__init__(self, address, price, numOfRooms, sizeInSquareFeet,
                 numOfBathrooms, hasFireplace, hasPool)
        
        # Initialize the landAmount attribute.
        self.landAmount = landAmount

    # The set_landAmount method is the mutator for the
    # landAmount attribute.

    def set_landAmount(self, landAmount):
        self.landAmount = landAmount

    # The get_landAmount method is the accessor for the
    # landAmount attribute.

    def get_landAmount(self):
        return self.landAmount
#%%


#Creating a main method that demonstrates the Property Class
def main():
    # Create an Property object for a house and passing in the values
    housing = Property('330 Green Road', 30000.00, 600, 1, 'No', 'Yes')

    # Display the Property data.
    print('Address:', housing.get_address())
    print('Proce:', housing.get_price())
#    print('Number of Rooms:', housing.get_numOfRooms())
    print('Size in Square Feet:', housing.get_sizeInSquareFeet())
    print('Number of Bathrooms:', housing.get_numOfBathrooms())
    print('Fireplace:', housing.get_hasFireplace())
    print('Pool:', housing.get_hasPool())

# Call the main function.
main()

#Creating a second main method that demonstrates the Condiminium, Townhouse, 
#and Family Home classes
def main():
    # Create an Condiminium object for a house and passing in the values
    condo = Condiminium('500 Landing Lane', 50000.00, 5, 1000, 4, 'No', 'Yes', 9)

    # Create an Townhouse object for a house and passing in the values
    town = TownHouse('1876 High Street', 150000.00, 5, 2000, 4, 'No', 'Yes', 'Yes')

    # Create an Family Home object for a house and passing in the values
    family = FamilyHome('432 Birch Street', 332000.00, 5, 4000, 4, 'Yes', 'Yes', '1/4 acre')

    #Print statements
    print('Available Housing')
    print('===================')
    
    # Display the data for a condiminium.
    print('Address:', condo.get_address())
    print('Proce:', condo.get_price())
    print('Number of Rooms:', condo.get_numOfRooms())
    print('Size in Square Feet:', condo.get_sizeInSquareFeet())
    print('Number of Bathrooms:', condo.get_numOfBathrooms())
    print('Fireplace:', condo.get_hasFireplace())
    print('Pool:', condo.get_hasPool())
    print('Floor number:', condo.get_floorNum())
    print()
    
    # Display the data for a townhouse.
    print('Address:', town.get_address())
    print('Proce:', town.get_price())
    print('Number of Rooms:', town.get_numOfRooms())
    print('Size in Square Feet:', town.get_sizeInSquareFeet())
    print('Number of Bathrooms:', town.get_numOfBathrooms())
    print('Fireplace:', town.get_hasFireplace())
    print('Pool:', town.get_hasPool())
    print("Apart of a Homeowner's Association: ", town.get_homeOwnerAssociation)
    print()
    
    # Display the data for a family home.
    print('Address:', family.get_address())
    print('Proce:', family.get_price())
    print('Number of Rooms:', family.get_numOfRooms())
    print('Size in Square Feet:', family.get_sizeInSquareFeet())
    print('Number of Bathrooms:', family.get_numOfBathrooms())
    print('Fireplace:', family.get_hasFireplace())
    print('Pool:', family.get_hasPool())
    print('Size of land:', family.get_landAmount())

# Call the main function.
main()