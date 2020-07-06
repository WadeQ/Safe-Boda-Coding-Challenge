# Safe-Boda-Coding-Challenge
Create an Android app that has a search field to find a Card from Magic: The Gathering Trading Card Game (TCG). When the user taps in any of the results the app must shown the Card detail screen. For this challenge you can use the free Scryfall API.

Scryfall API Hints

    Endpoint for Search cards: https://scryfall.com/docs/api/cards/search
        Example: https://api.scryfall.com/cards/search?q=duress
    Example of card names to search:
        Snapcaster Mage: https://api.scryfall.com/cards/search?q=snapcaster+mage
        Duress: https://api.scryfall.com/cards/search?q=duress
        Cards that has Field of in the name: https://api.scryfall.com/cards/search?q=field+of+

Features:

Home screen with a search field to find all the cards that match the term to search, by card name.
List the results of the search below the search field in the home screen. The results items should show the following attributes:

    Image of the card.
    Card name.
    Expansion/Set name.
    Card type (in the results it is called type_line).
    Rarity.

    Card detail screen that shows the following attributes:
        Image of the card.
        Card name.
        Expansion/Set name.
        Card type (in the results it is called type_line).
        Rarity.
        Released date.
        Mana cost.
        CMC.
        Oracle text.
        List of legalities.

Notes

    Forget about pagination in the search results. Just show the first 10 items.
    Take care of the designs. We don't expect pixel perfect designs but we want to see your ability to create beautiful designs.

Please submit code as if you intended to ship it to production. The details matter. Tests are expected, as is well written and simple idiomatic code.
