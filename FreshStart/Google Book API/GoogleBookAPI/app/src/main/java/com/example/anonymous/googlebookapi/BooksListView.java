package com.example.anonymous.googlebookapi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class BooksListView extends AppCompatActivity {

    ListView booksLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list_view);

        booksLV = (ListView) findViewById(R.id.listView);

        final String SAMPLE_JSON_RESPONSE_NULL = "{\\r\\n \\\"kind\\\": \\\"books#volumes\\\",\\r\\n \\\"totalItems\\\": 300,\\r\\n \\\"items\\\": [\\r\\n  {\\r\\n   \\\"kind\\\": \\\"books#volume\\\",\\r\\n   \\\"id\\\": \\\"IoW-AAAACAAJ\\\",\\r\\n   \\\"etag\\\": \\\"cClI6nNTZVk\\\",\\r\\n   \\\"selfLink\\\": \\\"https://www.googleapis.com/books/v1/volumes/IoW-AAAACAAJ\\\",\\r\\n   \\\"volumeInfo\\\": {\\r\\n    \\\"title\\\": \\\"Red Rackham's Treasure\\\",\\r\\n    \\\"authors\\\": [\\r\\n     \\\"Herg\\u00E9\\\"\\r\\n    ],\\r\\n    \\\"publisher\\\": \\\"Egmont Books (UK)\\\",\\r\\n    \\\"publishedDate\\\": \\\"2012\\\",\\r\\n    \\\"description\\\": \\\"Herg\\uFFFD's classic comic book creation Tintin is one of the most iconic characters in children's books. These highly collectible editions of the original 24 adventures will delight Tintin fans old and new. Perfect for lovers of graphic novels, mysteries and historical adventures. The world's most famous travelling reporter sets out in search of Red Rackham's treasure. Determined to find the treasure of the notorious pirate Red Rackham, Tintin and Captain Haddock set sail aboard the Sirius to find the shipwreck of the Unicorn. With the help of an ingenious shark-shaped submarine, Tintin follows the clues deep down on this ocean adventure. The Adventures of Tintin are among the best books for readers aged 8 and up. Herg\\uFFFD (Georges Remi) was born in Brussels in 1907. Over the course of 54 years he completed over 20 titles in The Adventures of Tintin series, which is now considered to be one of the greatest, if not the greatest, comics series of all time. Have you collected all 24 graphic novel adventures? Tintin in the Land of the Soviets Tintin in the Congo Tintin in America Tintin: Cigars of the Pharaoh Tintin: The Blue Lotus Tintin: The Broken Ear Tintin: The Black Island Tintin: King Ottakar's Sceptre Tintin: The Crab with the Golden Claws Tintin: The Shooting Star Tintin: The Secret of the Unicorn Tintin: Red Rackham's Treasure Tintin: The Seven Crystal Balls Tintin: Prisoners of the Sun Tintin: Land of Black Gold Tintin: Destination Moon Tintin: Explorers of the Moon Tintin: The Calculus Affair Tintin: The Red Sea Sharks Tintin in Tibet Tintin: The Castafiore Emerald Tintin: Flight 714 to Sydney The Adventures of Tintin and the Picaros Tintin and Alph-Art\\\",\\r\\n    \\\"industryIdentifiers\\\": [\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_10\\\",\\r\\n      \\\"identifier\\\": \\\"1405206233\\\"\\r\\n     },\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_13\\\",\\r\\n      \\\"identifier\\\": \\\"9781405206235\\\"\\r\\n     }\\r\\n    ],\\r\\n    \\\"readingModes\\\": {\\r\\n     \\\"text\\\": false,\\r\\n     \\\"image\\\": false\\r\\n    },\\r\\n    \\\"pageCount\\\": 62,\\r\\n    \\\"printType\\\": \\\"BOOK\\\",\\r\\n    \\\"categories\\\": [\\r\\n     \\\"Adventure\\\"\\r\\n    ],\\r\\n    \\\"averageRating\\\": 5.0,\\r\\n    \\\"ratingsCount\\\": 2,\\r\\n    \\\"maturityRating\\\": \\\"NOT_MATURE\\\",\\r\\n    \\\"allowAnonLogging\\\": false,\\r\\n    \\\"contentVersion\\\": \\\"preview-1.0.0\\\",\\r\\n    \\\"panelizationSummary\\\": {\\r\\n     \\\"containsEpubBubbles\\\": false,\\r\\n     \\\"containsImageBubbles\\\": false\\r\\n    },\\r\\n    \\\"imageLinks\\\": {\\r\\n     \\\"smallThumbnail\\\": \\\"http://books.google.com/books/content?id=IoW-AAAACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api\\\",\\r\\n     \\\"thumbnail\\\": \\\"http://books.google.com/books/content?id=IoW-AAAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\\\"\\r\\n    },\\r\\n    \\\"language\\\": \\\"en\\\",\\r\\n    \\\"previewLink\\\": \\\"http://books.google.co.in/books?id=IoW-AAAACAAJ&dq=subject:adventure&hl=&cd=1&source=gbs_api\\\",\\r\\n    \\\"infoLink\\\": \\\"http://books.google.co.in/books?id=IoW-AAAACAAJ&dq=subject:adventure&hl=&source=gbs_api\\\",\\r\\n    \\\"canonicalVolumeLink\\\": \\\"https://books.google.com/books/about/Red_Rackham_s_Treasure.html?hl=&id=IoW-AAAACAAJ\\\"\\r\\n   },\\r\\n   \\\"saleInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"saleability\\\": \\\"NOT_FOR_SALE\\\",\\r\\n    \\\"isEbook\\\": false\\r\\n   },\\r\\n   \\\"accessInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"viewability\\\": \\\"NO_PAGES\\\",\\r\\n    \\\"embeddable\\\": false,\\r\\n    \\\"publicDomain\\\": false,\\r\\n    \\\"textToSpeechPermission\\\": \\\"ALLOWED\\\",\\r\\n    \\\"epub\\\": {\\r\\n     \\\"isAvailable\\\": false\\r\\n    },\\r\\n    \\\"pdf\\\": {\\r\\n     \\\"isAvailable\\\": false\\r\\n    },\\r\\n    \\\"webReaderLink\\\": \\\"http://play.google.com/books/reader?id=IoW-AAAACAAJ&hl=&printsec=frontcover&source=gbs_api\\\",\\r\\n    \\\"accessViewStatus\\\": \\\"NONE\\\",\\r\\n    \\\"quoteSharingAllowed\\\": false\\r\\n   }\\r\\n  },\\r\\n  {\\r\\n   \\\"kind\\\": \\\"books#volume\\\",\\r\\n   \\\"id\\\": \\\"qYc8AwAAQBAJ\\\",\\r\\n   \\\"etag\\\": \\\"28t0dK4YLbA\\\",\\r\\n   \\\"selfLink\\\": \\\"https://www.googleapis.com/books/v1/volumes/qYc8AwAAQBAJ\\\",\\r\\n   \\\"volumeInfo\\\": {\\r\\n    \\\"title\\\": \\\"You Choose 2: Mayhem at Magic School\\\",\\r\\n    \\\"authors\\\": [\\r\\n     \\\"George Ivanoff\\\"\\r\\n    ],\\r\\n    \\\"publisher\\\": \\\"Random House Australia\\\",\\r\\n    \\\"publishedDate\\\": \\\"2014\\\",\\r\\n    \\\"description\\\": \\\"Abrand-new series of interactive novels for the highly adventurous. Read if you dare! Mistakes will cost you dearly! YOU CHOOSE...Supreme ruler of the world or misfortune for life! You are an ordinary kid... or so you think. Strange things start to happen. You make a rabbit appear from underneath your teacher's hat. Then you dream about a mystical diamond and a mysterious old woman with long white hair... It turns out you have magical powers. Do you try to keep your talents hidden or do you go off to Magic School?\\\",\\r\\n    \\\"industryIdentifiers\\\": [\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_13\\\",\\r\\n      \\\"identifier\\\": \\\"9780857983848\\\"\\r\\n     },\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_10\\\",\\r\\n      \\\"identifier\\\": \\\"0857983849\\\"\\r\\n     }\\r\\n    ],\\r\\n    \\\"readingModes\\\": {\\r\\n     \\\"text\\\": false,\\r\\n     \\\"image\\\": false\\r\\n    },\\r\\n    \\\"pageCount\\\": 160,\\r\\n    \\\"printType\\\": \\\"BOOK\\\",\\r\\n    \\\"categories\\\": [\\r\\n     \\\"Juvenile Fiction\\\"\\r\\n    ],\\r\\n    \\\"maturityRating\\\": \\\"NOT_MATURE\\\",\\r\\n    \\\"allowAnonLogging\\\": false,\\r\\n    \\\"contentVersion\\\": \\\"preview-1.0.0\\\",\\r\\n    \\\"imageLinks\\\": {\\r\\n     \\\"smallThumbnail\\\": \\\"http://books.google.com/books/content?id=qYc8AwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\\\",\\r\\n     \\\"thumbnail\\\": \\\"http://books.google.com/books/content?id=qYc8AwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\\\"\\r\\n    },\\r\\n    \\\"language\\\": \\\"en\\\",\\r\\n    \\\"previewLink\\\": \\\"http://books.google.co.in/books?id=qYc8AwAAQBAJ&printsec=frontcover&dq=subject:adventure&hl=&cd=2&source=gbs_api\\\",\\r\\n    \\\"infoLink\\\": \\\"http://books.google.co.in/books?id=qYc8AwAAQBAJ&dq=subject:adventure&hl=&source=gbs_api\\\",\\r\\n    \\\"canonicalVolumeLink\\\": \\\"https://books.google.com/books/about/You_Choose_2_Mayhem_at_Magic_School.html?hl=&id=qYc8AwAAQBAJ\\\"\\r\\n   },\\r\\n   \\\"saleInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"saleability\\\": \\\"NOT_FOR_SALE\\\",\\r\\n    \\\"isEbook\\\": false\\r\\n   },\\r\\n   \\\"accessInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"viewability\\\": \\\"PARTIAL\\\",\\r\\n    \\\"embeddable\\\": true,\\r\\n    \\\"publicDomain\\\": false,\\r\\n    \\\"textToSpeechPermission\\\": \\\"ALLOWED\\\",\\r\\n    \\\"epub\\\": {\\r\\n     \\\"isAvailable\\\": false\\r\\n    },\\r\\n    \\\"pdf\\\": {\\r\\n     \\\"isAvailable\\\": false\\r\\n    },\\r\\n    \\\"webReaderLink\\\": \\\"http://play.google.com/books/reader?id=qYc8AwAAQBAJ&hl=&printsec=frontcover&source=gbs_api\\\",\\r\\n    \\\"accessViewStatus\\\": \\\"SAMPLE\\\",\\r\\n    \\\"quoteSharingAllowed\\\": false\\r\\n   }\\r\\n  },\\r\\n  {\\r\\n   \\\"kind\\\": \\\"books#volume\\\",\\r\\n   \\\"id\\\": \\\"CQ0QuhLX7pIC\\\",\\r\\n   \\\"etag\\\": \\\"2r5lGb5nBSk\\\",\\r\\n   \\\"selfLink\\\": \\\"https://www.googleapis.com/books/v1/volumes/CQ0QuhLX7pIC\\\",\\r\\n   \\\"volumeInfo\\\": {\\r\\n    \\\"title\\\": \\\"Woodsong\\\",\\r\\n    \\\"authors\\\": [\\r\\n     \\\"Gary Paulsen\\\"\\r\\n    ],\\r\\n    \\\"publisher\\\": \\\"Simon and Schuster\\\",\\r\\n    \\\"publishedDate\\\": \\\"2007-05-08\\\",\\r\\n    \\\"description\\\": \\\"The author describes his love for the natural world, his involvement in dogsledding, and his experiences taking part in the Iditarod, the 1,180-mile dogsled race across Alaska.\\\",\\r\\n    \\\"industryIdentifiers\\\": [\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_13\\\",\\r\\n      \\\"identifier\\\": \\\"9781416939399\\\"\\r\\n     },\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_10\\\",\\r\\n      \\\"identifier\\\": \\\"1416939393\\\"\\r\\n     }\\r\\n    ],\\r\\n    \\\"readingModes\\\": {\\r\\n     \\\"text\\\": false,\\r\\n     \\\"image\\\": false\\r\\n    },\\r\\n    \\\"pageCount\\\": 144,\\r\\n    \\\"printType\\\": \\\"BOOK\\\",\\r\\n    \\\"categories\\\": [\\r\\n     \\\"Juvenile Nonfiction\\\"\\r\\n    ],\\r\\n    \\\"averageRating\\\": 3.5,\\r\\n    \\\"ratingsCount\\\": 26,\\r\\n    \\\"maturityRating\\\": \\\"NOT_MATURE\\\",\\r\\n    \\\"allowAnonLogging\\\": false,\\r\\n    \\\"contentVersion\\\": \\\"0.2.0.0.preview.0\\\",\\r\\n    \\\"imageLinks\\\": {\\r\\n     \\\"smallThumbnail\\\": \\\"http://books.google.com/books/content?id=CQ0QuhLX7pIC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\\\",\\r\\n     \\\"thumbnail\\\": \\\"http://books.google.com/books/content?id=CQ0QuhLX7pIC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\\\"\\r\\n    },\\r\\n    \\\"language\\\": \\\"en\\\",\\r\\n    \\\"previewLink\\\": \\\"http://books.google.co.in/books?id=CQ0QuhLX7pIC&printsec=frontcover&dq=subject:adventure&hl=&cd=3&source=gbs_api\\\",\\r\\n    \\\"infoLink\\\": \\\"http://books.google.co.in/books?id=CQ0QuhLX7pIC&dq=subject:adventure&hl=&source=gbs_api\\\",\\r\\n    \\\"canonicalVolumeLink\\\": \\\"https://books.google.com/books/about/Woodsong.html?hl=&id=CQ0QuhLX7pIC\\\"\\r\\n   },\\r\\n   \\\"saleInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"saleability\\\": \\\"NOT_FOR_SALE\\\",\\r\\n    \\\"isEbook\\\": false\\r\\n   },\\r\\n   \\\"accessInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"viewability\\\": \\\"PARTIAL\\\",\\r\\n    \\\"embeddable\\\": true,\\r\\n    \\\"publicDomain\\\": false,\\r\\n    \\\"textToSpeechPermission\\\": \\\"ALLOWED_FOR_ACCESSIBILITY\\\",\\r\\n    \\\"epub\\\": {\\r\\n     \\\"isAvailable\\\": false\\r\\n    },\\r\\n    \\\"pdf\\\": {\\r\\n     \\\"isAvailable\\\": false\\r\\n    },\\r\\n    \\\"webReaderLink\\\": \\\"http://play.google.com/books/reader?id=CQ0QuhLX7pIC&hl=&printsec=frontcover&source=gbs_api\\\",\\r\\n    \\\"accessViewStatus\\\": \\\"SAMPLE\\\",\\r\\n    \\\"quoteSharingAllowed\\\": false\\r\\n   }\\r\\n  },\\r\\n  {\\r\\n   \\\"kind\\\": \\\"books#volume\\\",\\r\\n   \\\"id\\\": \\\"YlmYBgAAQBAJ\\\",\\r\\n   \\\"etag\\\": \\\"HIjzX4HgeGw\\\",\\r\\n   \\\"selfLink\\\": \\\"https://www.googleapis.com/books/v1/volumes/YlmYBgAAQBAJ\\\",\\r\\n   \\\"volumeInfo\\\": {\\r\\n    \\\"title\\\": \\\"The Boy Who Sailed with Blake\\\",\\r\\n    \\\"subtitle\\\": \\\"\\\",\\r\\n    \\\"authors\\\": [\\r\\n     \\\"William Henry Giles Kingston\\\"\\r\\n    ],\\r\\n    \\\"publisher\\\": \\\"Library of Alexandria\\\",\\r\\n    \\\"publishedDate\\\": \\\"190?\\\",\\r\\n    \\\"description\\\": \\\"\\u00D2Hark! the bells of Saint Michael\\u00D5s are sending forth a jovial peal!\\u00D3 exclaimed Lancelot Kerridge, as he, Dick Harvey, and I were one day on board his boat fishing for mackerel, about two miles off the sea-port town of Lyme. \\u00D2What they are saying I should mightily like to know, for depend on\\u00D5t it\\u00D5s something of importance. Haul in the lines, Ben!\\u00D3 he continued, addressing me; \\u00D2and, Dick, put an oar out to windward. I\\u00D5ll take the helm. We shall fetch the Cob by keeping our luff.\\u00D3 The wind was off shore, but as we were to the westward of the Cob, and the tide was making in the same direction, we could easily fetch it. The water was smooth, the sea blue and bright as the eyes of sweet Cicely Kerridge, my friend Lancelot\\u00D5s young sister, while scarcely a cloud dimmed the clear sky overhead. Lyme, then containing but one thousand inhabitants, where my two companions and I lived, is situated in Dorsetshire, near its western border, on the northern shore of a wide bay, formed by the Bill of Portland on the east and the Start Point on the west. Along the coast are several other towns, of which Dartmouth, owing to its excellent harbour, is the most considerable, besides numerous villages, including Charmouth and Uplyme. A line of cliffs of no great height extends away on either side of Lyme, which stands at the bottom of a valley; while beyond it rise the green slopes of Colway and Uplyme, hills overlooking the town. On the eastern side was the house of my father, Captain Roger Bracewell. He had commanded several of the trading ships of Master Humphrey Blake, of Bridgwater, at one time a merchant of renown, and the father of Captain Robert Blake, who had already made his name famous for his gallant defence of Prior\\u00D5s Hill when Bristol was besieged by Prince Rupert, until it was yielded in a dastardly fashion by Governor Fiennes.\\\",\\r\\n    \\\"industryIdentifiers\\\": [\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_13\\\",\\r\\n      \\\"identifier\\\": \\\"9781465584441\\\"\\r\\n     },\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_10\\\",\\r\\n      \\\"identifier\\\": \\\"1465584447\\\"\\r\\n     }\\r\\n    ],\\r\\n    \\\"readingModes\\\": {\\r\\n     \\\"text\\\": true,\\r\\n     \\\"image\\\": false\\r\\n    },\\r\\n    \\\"pageCount\\\": 164,\\r\\n    \\\"printType\\\": \\\"BOOK\\\",\\r\\n    \\\"categories\\\": [\\r\\n     \\\"Great Britain\\\"\\r\\n    ],\\r\\n    \\\"maturityRating\\\": \\\"NOT_MATURE\\\",\\r\\n    \\\"allowAnonLogging\\\": false,\\r\\n    \\\"contentVersion\\\": \\\"1.1.1.0.preview.2\\\",\\r\\n    \\\"panelizationSummary\\\": {\\r\\n     \\\"containsEpubBubbles\\\": false,\\r\\n     \\\"containsImageBubbles\\\": false\\r\\n    },\\r\\n    \\\"imageLinks\\\": {\\r\\n     \\\"smallThumbnail\\\": \\\"http://books.google.com/books/content?id=YlmYBgAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\\\",\\r\\n     \\\"thumbnail\\\": \\\"http://books.google.com/books/content?id=YlmYBgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\\\"\\r\\n    },\\r\\n    \\\"language\\\": \\\"en\\\",\\r\\n    \\\"previewLink\\\": \\\"http://books.google.co.in/books?id=YlmYBgAAQBAJ&printsec=frontcover&dq=subject:adventure&hl=&cd=4&source=gbs_api\\\",\\r\\n    \\\"infoLink\\\": \\\"https://play.google.com/store/books/details?id=YlmYBgAAQBAJ&source=gbs_api\\\",\\r\\n    \\\"canonicalVolumeLink\\\": \\\"https://market.android.com/details?id=book-YlmYBgAAQBAJ\\\"\\r\\n   },\\r\\n   \\\"saleInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"saleability\\\": \\\"FOR_SALE\\\",\\r\\n    \\\"isEbook\\\": true,\\r\\n    \\\"listPrice\\\": {\\r\\n     \\\"amount\\\": 350.0,\\r\\n     \\\"currencyCode\\\": \\\"INR\\\"\\r\\n    },\\r\\n    \\\"retailPrice\\\": {\\r\\n     \\\"amount\\\": 350.0,\\r\\n     \\\"currencyCode\\\": \\\"INR\\\"\\r\\n    },\\r\\n    \\\"buyLink\\\": \\\"https://play.google.com/store/books/details?id=YlmYBgAAQBAJ&rdid=book-YlmYBgAAQBAJ&rdot=1&source=gbs_api\\\",\\r\\n    \\\"offers\\\": [\\r\\n     {\\r\\n      \\\"finskyOfferType\\\": 1,\\r\\n      \\\"listPrice\\\": {\\r\\n       \\\"amountInMicros\\\": 3.5E8,\\r\\n       \\\"currencyCode\\\": \\\"INR\\\"\\r\\n      },\\r\\n      \\\"retailPrice\\\": {\\r\\n       \\\"amountInMicros\\\": 3.5E8,\\r\\n       \\\"currencyCode\\\": \\\"INR\\\"\\r\\n      }\\r\\n     }\\r\\n    ]\\r\\n   },\\r\\n   \\\"accessInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"viewability\\\": \\\"PARTIAL\\\",\\r\\n    \\\"embeddable\\\": true,\\r\\n    \\\"publicDomain\\\": false,\\r\\n    \\\"textToSpeechPermission\\\": \\\"ALLOWED\\\",\\r\\n    \\\"epub\\\": {\\r\\n     \\\"isAvailable\\\": true,\\r\\n     \\\"acsTokenLink\\\": \\\"http://books.google.co.in/books/download/The_Boy_Who_Sailed_with_Blake-sample-epub.acsm?id=YlmYBgAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\\\"\\r\\n    },\\r\\n    \\\"pdf\\\": {\\r\\n     \\\"isAvailable\\\": false\\r\\n    },\\r\\n    \\\"webReaderLink\\\": \\\"http://play.google.com/books/reader?id=YlmYBgAAQBAJ&hl=&printsec=frontcover&source=gbs_api\\\",\\r\\n    \\\"accessViewStatus\\\": \\\"SAMPLE\\\",\\r\\n    \\\"quoteSharingAllowed\\\": false\\r\\n   }\\r\\n  },\\r\\n  {\\r\\n   \\\"kind\\\": \\\"books#volume\\\",\\r\\n   \\\"id\\\": \\\"4yoXCgAAQBAJ\\\",\\r\\n   \\\"etag\\\": \\\"UfaJEImg6VA\\\",\\r\\n   \\\"selfLink\\\": \\\"https://www.googleapis.com/books/v1/volumes/4yoXCgAAQBAJ\\\",\\r\\n   \\\"volumeInfo\\\": {\\r\\n    \\\"title\\\": \\\"Can You Survive a Virus Outbreak?\\\",\\r\\n    \\\"subtitle\\\": \\\"An Interactive Doomsday Adventure\\\",\\r\\n    \\\"authors\\\": [\\r\\n     \\\"Matt Doeden\\\"\\r\\n    ],\\r\\n    \\\"publisher\\\": \\\"Capstone\\\",\\r\\n    \\\"publishedDate\\\": \\\"2015-08-01\\\",\\r\\n    \\\"description\\\": \\\"\\\\\\\"A You Choose adventure about surviving a virus outbreak\\\\\\\"--\\\",\\r\\n    \\\"industryIdentifiers\\\": [\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_13\\\",\\r\\n      \\\"identifier\\\": \\\"9781491458518\\\"\\r\\n     },\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_10\\\",\\r\\n      \\\"identifier\\\": \\\"1491458518\\\"\\r\\n     }\\r\\n    ],\\r\\n    \\\"readingModes\\\": {\\r\\n     \\\"text\\\": false,\\r\\n     \\\"image\\\": true\\r\\n    },\\r\\n    \\\"pageCount\\\": 112,\\r\\n    \\\"printType\\\": \\\"BOOK\\\",\\r\\n    \\\"categories\\\": [\\r\\n     \\\"Juvenile Fiction\\\"\\r\\n    ],\\r\\n    \\\"maturityRating\\\": \\\"NOT_MATURE\\\",\\r\\n    \\\"allowAnonLogging\\\": false,\\r\\n    \\\"contentVersion\\\": \\\"preview-1.0.0\\\",\\r\\n    \\\"imageLinks\\\": {\\r\\n     \\\"smallThumbnail\\\": \\\"http://books.google.com/books/content?id=4yoXCgAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\\\",\\r\\n     \\\"thumbnail\\\": \\\"http://books.google.com/books/content?id=4yoXCgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\\\"\\r\\n    },\\r\\n    \\\"language\\\": \\\"en\\\",\\r\\n    \\\"previewLink\\\": \\\"http://books.google.co.in/books?id=4yoXCgAAQBAJ&printsec=frontcover&dq=subject:adventure&hl=&cd=5&source=gbs_api\\\",\\r\\n    \\\"infoLink\\\": \\\"http://books.google.co.in/books?id=4yoXCgAAQBAJ&dq=subject:adventure&hl=&source=gbs_api\\\",\\r\\n    \\\"canonicalVolumeLink\\\": \\\"https://books.google.com/books/about/Can_You_Survive_a_Virus_Outbreak.html?hl=&id=4yoXCgAAQBAJ\\\"\\r\\n   },\\r\\n   \\\"saleInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"saleability\\\": \\\"NOT_FOR_SALE\\\",\\r\\n    \\\"isEbook\\\": false\\r\\n   },\\r\\n   \\\"accessInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"viewability\\\": \\\"PARTIAL\\\",\\r\\n    \\\"embeddable\\\": true,\\r\\n    \\\"publicDomain\\\": false,\\r\\n    \\\"textToSpeechPermission\\\": \\\"ALLOWED\\\",\\r\\n    \\\"epub\\\": {\\r\\n     \\\"isAvailable\\\": false\\r\\n    },\\r\\n    \\\"pdf\\\": {\\r\\n     \\\"isAvailable\\\": false\\r\\n    },\\r\\n    \\\"webReaderLink\\\": \\\"http://play.google.com/books/reader?id=4yoXCgAAQBAJ&hl=&printsec=frontcover&source=gbs_api\\\",\\r\\n    \\\"accessViewStatus\\\": \\\"SAMPLE\\\",\\r\\n    \\\"quoteSharingAllowed\\\": false\\r\\n   }\\r\\n  },\\r\\n  {\\r\\n   \\\"kind\\\": \\\"books#volume\\\",\\r\\n   \\\"id\\\": \\\"1P3IaTKWQ3oC\\\",\\r\\n   \\\"etag\\\": \\\"U31FuEJH17k\\\",\\r\\n   \\\"selfLink\\\": \\\"https://www.googleapis.com/books/v1/volumes/1P3IaTKWQ3oC\\\",\\r\\n   \\\"volumeInfo\\\": {\\r\\n    \\\"title\\\": \\\"One False Note\\\",\\r\\n    \\\"authors\\\": [\\r\\n     \\\"Gordon Korman\\\"\\r\\n    ],\\r\\n    \\\"publisher\\\": \\\"Scholastic Inc.\\\",\\r\\n    \\\"publishedDate\\\": \\\"2008\\\",\\r\\n    \\\"description\\\": \\\"Amy and Dan Cahill's quest to find the million dollars takes them to Vienna, where they must outwit their power-hungry relatives as they seek to solve a clue involving Mozart.\\\",\\r\\n    \\\"industryIdentifiers\\\": [\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_13\\\",\\r\\n      \\\"identifier\\\": \\\"9780545060424\\\"\\r\\n     },\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_10\\\",\\r\\n      \\\"identifier\\\": \\\"0545060427\\\"\\r\\n     }\\r\\n    ],\\r\\n    \\\"readingModes\\\": {\\r\\n     \\\"text\\\": false,\\r\\n     \\\"image\\\": true\\r\\n    },\\r\\n    \\\"pageCount\\\": 174,\\r\\n    \\\"printType\\\": \\\"BOOK\\\",\\r\\n    \\\"categories\\\": [\\r\\n     \\\"Juvenile Fiction\\\"\\r\\n    ],\\r\\n    \\\"averageRating\\\": 4.0,\\r\\n    \\\"ratingsCount\\\": 61,\\r\\n    \\\"maturityRating\\\": \\\"NOT_MATURE\\\",\\r\\n    \\\"allowAnonLogging\\\": false,\\r\\n    \\\"contentVersion\\\": \\\"0.0.1.0.preview.1\\\",\\r\\n    \\\"imageLinks\\\": {\\r\\n     \\\"smallThumbnail\\\": \\\"http://books.google.com/books/content?id=1P3IaTKWQ3oC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\\\",\\r\\n     \\\"thumbnail\\\": \\\"http://books.google.com/books/content?id=1P3IaTKWQ3oC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\\\"\\r\\n    },\\r\\n    \\\"language\\\": \\\"en\\\",\\r\\n    \\\"previewLink\\\": \\\"http://books.google.co.in/books?id=1P3IaTKWQ3oC&printsec=frontcover&dq=subject:adventure&hl=&cd=6&source=gbs_api\\\",\\r\\n    \\\"infoLink\\\": \\\"http://books.google.co.in/books?id=1P3IaTKWQ3oC&dq=subject:adventure&hl=&source=gbs_api\\\",\\r\\n    \\\"canonicalVolumeLink\\\": \\\"https://books.google.com/books/about/One_False_Note.html?hl=&id=1P3IaTKWQ3oC\\\"\\r\\n   },\\r\\n   \\\"saleInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"saleability\\\": \\\"NOT_FOR_SALE\\\",\\r\\n    \\\"isEbook\\\": false\\r\\n   },\\r\\n   \\\"accessInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"viewability\\\": \\\"PARTIAL\\\",\\r\\n    \\\"embeddable\\\": true,\\r\\n    \\\"publicDomain\\\": false,\\r\\n    \\\"textToSpeechPermission\\\": \\\"ALLOWED_FOR_ACCESSIBILITY\\\",\\r\\n    \\\"epub\\\": {\\r\\n     \\\"isAvailable\\\": false\\r\\n    },\\r\\n    \\\"pdf\\\": {\\r\\n     \\\"isAvailable\\\": true,\\r\\n     \\\"acsTokenLink\\\": \\\"http://books.google.co.in/books/download/One_False_Note-sample-pdf.acsm?id=1P3IaTKWQ3oC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\\\"\\r\\n    },\\r\\n    \\\"webReaderLink\\\": \\\"http://play.google.com/books/reader?id=1P3IaTKWQ3oC&hl=&printsec=frontcover&source=gbs_api\\\",\\r\\n    \\\"accessViewStatus\\\": \\\"SAMPLE\\\",\\r\\n    \\\"quoteSharingAllowed\\\": false\\r\\n   }\\r\\n  },\\r\\n  {\\r\\n   \\\"kind\\\": \\\"books#volume\\\",\\r\\n   \\\"id\\\": \\\"x0cvCwAAQBAJ\\\",\\r\\n   \\\"etag\\\": \\\"7/wcFZGE+0w\\\",\\r\\n   \\\"selfLink\\\": \\\"https://www.googleapis.com/books/v1/volumes/x0cvCwAAQBAJ\\\",\\r\\n   \\\"volumeInfo\\\": {\\r\\n    \\\"title\\\": \\\"Can You Survive in a Dystopia?\\\",\\r\\n    \\\"subtitle\\\": \\\"An Interactive Doomsday Adventure\\\",\\r\\n    \\\"authors\\\": [\\r\\n     \\\"Anthony Wacholtz\\\"\\r\\n    ],\\r\\n    \\\"publisher\\\": \\\"Capstone\\\",\\r\\n    \\\"publishedDate\\\": \\\"2016-01-01\\\",\\r\\n    \\\"description\\\": \\\"The world is a shell of its former self. Most of the world's population is gone. You're one of the few lucky survivors, but can you trust the people that remain? Or will you face the bleak future on your own? When YOU CHOOSE what to do next, the choices you make could mean the difference between life and death.? How long can you survive in a dystopia?\\\",\\r\\n    \\\"industryIdentifiers\\\": [\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_13\\\",\\r\\n      \\\"identifier\\\": \\\"9781491481103\\\"\\r\\n     },\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_10\\\",\\r\\n      \\\"identifier\\\": \\\"1491481102\\\"\\r\\n     }\\r\\n    ],\\r\\n    \\\"readingModes\\\": {\\r\\n     \\\"text\\\": false,\\r\\n     \\\"image\\\": true\\r\\n    },\\r\\n    \\\"pageCount\\\": 112,\\r\\n    \\\"printType\\\": \\\"BOOK\\\",\\r\\n    \\\"categories\\\": [\\r\\n     \\\"Juvenile Fiction\\\"\\r\\n    ],\\r\\n    \\\"maturityRating\\\": \\\"NOT_MATURE\\\",\\r\\n    \\\"allowAnonLogging\\\": false,\\r\\n    \\\"contentVersion\\\": \\\"preview-1.0.0\\\",\\r\\n    \\\"imageLinks\\\": {\\r\\n     \\\"smallThumbnail\\\": \\\"http://books.google.com/books/content?id=x0cvCwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\\\",\\r\\n     \\\"thumbnail\\\": \\\"http://books.google.com/books/content?id=x0cvCwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\\\"\\r\\n    },\\r\\n    \\\"language\\\": \\\"en\\\",\\r\\n    \\\"previewLink\\\": \\\"http://books.google.co.in/books?id=x0cvCwAAQBAJ&printsec=frontcover&dq=subject:adventure&hl=&cd=7&source=gbs_api\\\",\\r\\n    \\\"infoLink\\\": \\\"http://books.google.co.in/books?id=x0cvCwAAQBAJ&dq=subject:adventure&hl=&source=gbs_api\\\",\\r\\n    \\\"canonicalVolumeLink\\\": \\\"https://books.google.com/books/about/Can_You_Survive_in_a_Dystopia.html?hl=&id=x0cvCwAAQBAJ\\\"\\r\\n   },\\r\\n   \\\"saleInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"saleability\\\": \\\"NOT_FOR_SALE\\\",\\r\\n    \\\"isEbook\\\": false\\r\\n   },\\r\\n   \\\"accessInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"viewability\\\": \\\"PARTIAL\\\",\\r\\n    \\\"embeddable\\\": true,\\r\\n    \\\"publicDomain\\\": false,\\r\\n    \\\"textToSpeechPermission\\\": \\\"ALLOWED\\\",\\r\\n    \\\"epub\\\": {\\r\\n     \\\"isAvailable\\\": false\\r\\n    },\\r\\n    \\\"pdf\\\": {\\r\\n     \\\"isAvailable\\\": false\\r\\n    },\\r\\n    \\\"webReaderLink\\\": \\\"http://play.google.com/books/reader?id=x0cvCwAAQBAJ&hl=&printsec=frontcover&source=gbs_api\\\",\\r\\n    \\\"accessViewStatus\\\": \\\"SAMPLE\\\",\\r\\n    \\\"quoteSharingAllowed\\\": false\\r\\n   }\\r\\n  },\\r\\n  {\\r\\n   \\\"kind\\\": \\\"books#volume\\\",\\r\\n   \\\"id\\\": \\\"QVs9AwAAQBAJ\\\",\\r\\n   \\\"etag\\\": \\\"pst4n+zDKFY\\\",\\r\\n   \\\"selfLink\\\": \\\"https://www.googleapis.com/books/v1/volumes/QVs9AwAAQBAJ\\\",\\r\\n   \\\"volumeInfo\\\": {\\r\\n    \\\"title\\\": \\\"The Wrath of the Lizard Lord\\\",\\r\\n    \\\"authors\\\": [\\r\\n     \\\"Jon Mayhew\\\"\\r\\n    ],\\r\\n    \\\"publisher\\\": \\\"A&C Black\\\",\\r\\n    \\\"publishedDate\\\": \\\"2014\\\",\\r\\n    \\\"description\\\": \\\"Dakkar is plunged into a new and perilous adventure as history and fantasy collide for a breathtaking showdown in a mysterious world at the centre of the earth.\\\",\\r\\n    \\\"industryIdentifiers\\\": [\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_13\\\",\\r\\n      \\\"identifier\\\": \\\"9781408826324\\\"\\r\\n     },\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_10\\\",\\r\\n      \\\"identifier\\\": \\\"1408826321\\\"\\r\\n     }\\r\\n    ],\\r\\n    \\\"readingModes\\\": {\\r\\n     \\\"text\\\": false,\\r\\n     \\\"image\\\": true\\r\\n    },\\r\\n    \\\"pageCount\\\": 263,\\r\\n    \\\"printType\\\": \\\"BOOK\\\",\\r\\n    \\\"categories\\\": [\\r\\n     \\\"Adventure\\\"\\r\\n    ],\\r\\n    \\\"maturityRating\\\": \\\"NOT_MATURE\\\",\\r\\n    \\\"allowAnonLogging\\\": false,\\r\\n    \\\"contentVersion\\\": \\\"preview-1.0.0\\\",\\r\\n    \\\"imageLinks\\\": {\\r\\n     \\\"smallThumbnail\\\": \\\"http://books.google.com/books/content?id=QVs9AwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\\\",\\r\\n     \\\"thumbnail\\\": \\\"http://books.google.com/books/content?id=QVs9AwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\\\"\\r\\n    },\\r\\n    \\\"language\\\": \\\"en\\\",\\r\\n    \\\"previewLink\\\": \\\"http://books.google.co.in/books?id=QVs9AwAAQBAJ&printsec=frontcover&dq=subject:adventure&hl=&cd=8&source=gbs_api\\\",\\r\\n    \\\"infoLink\\\": \\\"http://books.google.co.in/books?id=QVs9AwAAQBAJ&dq=subject:adventure&hl=&source=gbs_api\\\",\\r\\n    \\\"canonicalVolumeLink\\\": \\\"https://books.google.com/books/about/The_Wrath_of_the_Lizard_Lord.html?hl=&id=QVs9AwAAQBAJ\\\"\\r\\n   },\\r\\n   \\\"saleInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"saleability\\\": \\\"NOT_FOR_SALE\\\",\\r\\n    \\\"isEbook\\\": false\\r\\n   },\\r\\n   \\\"accessInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"viewability\\\": \\\"PARTIAL\\\",\\r\\n    \\\"embeddable\\\": true,\\r\\n    \\\"publicDomain\\\": false,\\r\\n    \\\"textToSpeechPermission\\\": \\\"ALLOWED\\\",\\r\\n    \\\"epub\\\": {\\r\\n     \\\"isAvailable\\\": false\\r\\n    },\\r\\n    \\\"pdf\\\": {\\r\\n     \\\"isAvailable\\\": false\\r\\n    },\\r\\n    \\\"webReaderLink\\\": \\\"http://play.google.com/books/reader?id=QVs9AwAAQBAJ&hl=&printsec=frontcover&source=gbs_api\\\",\\r\\n    \\\"accessViewStatus\\\": \\\"SAMPLE\\\",\\r\\n    \\\"quoteSharingAllowed\\\": false\\r\\n   }\\r\\n  },\\r\\n  {\\r\\n   \\\"kind\\\": \\\"books#volume\\\",\\r\\n   \\\"id\\\": \\\"AyznSi4MMm4C\\\",\\r\\n   \\\"etag\\\": \\\"1xvmbd6COcs\\\",\\r\\n   \\\"selfLink\\\": \\\"https://www.googleapis.com/books/v1/volumes/AyznSi4MMm4C\\\",\\r\\n   \\\"volumeInfo\\\": {\\r\\n    \\\"title\\\": \\\"Dogsong\\\",\\r\\n    \\\"authors\\\": [\\r\\n     \\\"Gary Paulsen\\\"\\r\\n    ],\\r\\n    \\\"publisher\\\": \\\"Simon and Schuster\\\",\\r\\n    \\\"publishedDate\\\": \\\"2007-05-08\\\",\\r\\n    \\\"description\\\": \\\"A fourteen-year-old Eskimo boy who feels at odds with aspects of modern life takes a 1400-mile journey by dog sled across ice, tundra, and mountains seeking his own \\\\\\\"song\\\\\\\" of himself.\\\",\\r\\n    \\\"industryIdentifiers\\\": [\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_13\\\",\\r\\n      \\\"identifier\\\": \\\"9781416939191\\\"\\r\\n     },\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_10\\\",\\r\\n      \\\"identifier\\\": \\\"1416939199\\\"\\r\\n     }\\r\\n    ],\\r\\n    \\\"readingModes\\\": {\\r\\n     \\\"text\\\": false,\\r\\n     \\\"image\\\": false\\r\\n    },\\r\\n    \\\"pageCount\\\": 192,\\r\\n    \\\"printType\\\": \\\"BOOK\\\",\\r\\n    \\\"categories\\\": [\\r\\n     \\\"Juvenile Fiction\\\"\\r\\n    ],\\r\\n    \\\"averageRating\\\": 3.5,\\r\\n    \\\"ratingsCount\\\": 15,\\r\\n    \\\"maturityRating\\\": \\\"NOT_MATURE\\\",\\r\\n    \\\"allowAnonLogging\\\": false,\\r\\n    \\\"contentVersion\\\": \\\"preview-1.0.0\\\",\\r\\n    \\\"imageLinks\\\": {\\r\\n     \\\"smallThumbnail\\\": \\\"http://books.google.com/books/content?id=AyznSi4MMm4C&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\\\",\\r\\n     \\\"thumbnail\\\": \\\"http://books.google.com/books/content?id=AyznSi4MMm4C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\\\"\\r\\n    },\\r\\n    \\\"language\\\": \\\"en\\\",\\r\\n    \\\"previewLink\\\": \\\"http://books.google.co.in/books?id=AyznSi4MMm4C&printsec=frontcover&dq=subject:adventure&hl=&cd=9&source=gbs_api\\\",\\r\\n    \\\"infoLink\\\": \\\"http://books.google.co.in/books?id=AyznSi4MMm4C&dq=subject:adventure&hl=&source=gbs_api\\\",\\r\\n    \\\"canonicalVolumeLink\\\": \\\"https://books.google.com/books/about/Dogsong.html?hl=&id=AyznSi4MMm4C\\\"\\r\\n   },\\r\\n   \\\"saleInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"saleability\\\": \\\"NOT_FOR_SALE\\\",\\r\\n    \\\"isEbook\\\": false\\r\\n   },\\r\\n   \\\"accessInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"viewability\\\": \\\"PARTIAL\\\",\\r\\n    \\\"embeddable\\\": true,\\r\\n    \\\"publicDomain\\\": false,\\r\\n    \\\"textToSpeechPermission\\\": \\\"ALLOWED_FOR_ACCESSIBILITY\\\",\\r\\n    \\\"epub\\\": {\\r\\n     \\\"isAvailable\\\": false\\r\\n    },\\r\\n    \\\"pdf\\\": {\\r\\n     \\\"isAvailable\\\": false\\r\\n    },\\r\\n    \\\"webReaderLink\\\": \\\"http://play.google.com/books/reader?id=AyznSi4MMm4C&hl=&printsec=frontcover&source=gbs_api\\\",\\r\\n    \\\"accessViewStatus\\\": \\\"SAMPLE\\\",\\r\\n    \\\"quoteSharingAllowed\\\": false\\r\\n   }\\r\\n  },\\r\\n  {\\r\\n   \\\"kind\\\": \\\"books#volume\\\",\\r\\n   \\\"id\\\": \\\"Oi9vfDvIuBUC\\\",\\r\\n   \\\"etag\\\": \\\"Z+B3luo3W4g\\\",\\r\\n   \\\"selfLink\\\": \\\"https://www.googleapis.com/books/v1/volumes/Oi9vfDvIuBUC\\\",\\r\\n   \\\"volumeInfo\\\": {\\r\\n    \\\"title\\\": \\\"Treasure Island\\\",\\r\\n    \\\"authors\\\": [\\r\\n     \\\"Robert Louis Stevenson\\\"\\r\\n    ],\\r\\n    \\\"publisher\\\": \\\"Collector's Library\\\",\\r\\n    \\\"publishedDate\\\": \\\"2004\\\",\\r\\n    \\\"description\\\": \\\"Treasure Island is one of the best-loved children's stories of all time but is a wonderful adventure story that can be enjoyed at any age.When Jim Hawkins finds a pirate's treasure map in an old sailor's sea trunk the local doctor and squire take him with them to find the island and the treasure. But Long John Silver, with his missing leg and talking parrot, has his own ideas about who should find the treasure.Illustrated by H M Brock, with an Afterword by Sam Gilpin.\\\",\\r\\n    \\\"industryIdentifiers\\\": [\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_10\\\",\\r\\n      \\\"identifier\\\": \\\"1904633447\\\"\\r\\n     },\\r\\n     {\\r\\n      \\\"type\\\": \\\"ISBN_13\\\",\\r\\n      \\\"identifier\\\": \\\"9781904633440\\\"\\r\\n     }\\r\\n    ],\\r\\n    \\\"readingModes\\\": {\\r\\n     \\\"text\\\": true,\\r\\n     \\\"image\\\": true\\r\\n    },\\r\\n    \\\"pageCount\\\": 302,\\r\\n    \\\"printType\\\": \\\"BOOK\\\",\\r\\n    \\\"categories\\\": [\\r\\n     \\\"Fiction\\\"\\r\\n    ],\\r\\n    \\\"averageRating\\\": 3.0,\\r\\n    \\\"ratingsCount\\\": 3,\\r\\n    \\\"maturityRating\\\": \\\"NOT_MATURE\\\",\\r\\n    \\\"allowAnonLogging\\\": false,\\r\\n    \\\"contentVersion\\\": \\\"3.6.3.0.preview.3\\\",\\r\\n    \\\"imageLinks\\\": {\\r\\n     \\\"smallThumbnail\\\": \\\"http://books.google.com/books/content?id=Oi9vfDvIuBUC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\\\",\\r\\n     \\\"thumbnail\\\": \\\"http://books.google.com/books/content?id=Oi9vfDvIuBUC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\\\"\\r\\n    },\\r\\n    \\\"language\\\": \\\"en\\\",\\r\\n    \\\"previewLink\\\": \\\"http://books.google.co.in/books?id=Oi9vfDvIuBUC&printsec=frontcover&dq=subject:adventure&hl=&cd=10&source=gbs_api\\\",\\r\\n    \\\"infoLink\\\": \\\"http://books.google.co.in/books?id=Oi9vfDvIuBUC&dq=subject:adventure&hl=&source=gbs_api\\\",\\r\\n    \\\"canonicalVolumeLink\\\": \\\"https://books.google.com/books/about/Treasure_Island.html?hl=&id=Oi9vfDvIuBUC\\\"\\r\\n   },\\r\\n   \\\"saleInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"saleability\\\": \\\"NOT_FOR_SALE\\\",\\r\\n    \\\"isEbook\\\": false\\r\\n   },\\r\\n   \\\"accessInfo\\\": {\\r\\n    \\\"country\\\": \\\"IN\\\",\\r\\n    \\\"viewability\\\": \\\"PARTIAL\\\",\\r\\n    \\\"embeddable\\\": true,\\r\\n    \\\"publicDomain\\\": false,\\r\\n    \\\"textToSpeechPermission\\\": \\\"ALLOWED\\\",\\r\\n    \\\"epub\\\": {\\r\\n     \\\"isAvailable\\\": true,\\r\\n     \\\"acsTokenLink\\\": \\\"http://books.google.co.in/books/download/Treasure_Island-sample-epub.acsm?id=Oi9vfDvIuBUC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\\\"\\r\\n    },\\r\\n    \\\"pdf\\\": {\\r\\n     \\\"isAvailable\\\": false\\r\\n    },\\r\\n    \\\"webReaderLink\\\": \\\"http://play.google.com/books/reader?id=Oi9vfDvIuBUC&hl=&printsec=frontcover&source=gbs_api\\\",\\r\\n    \\\"accessViewStatus\\\": \\\"SAMPLE\\\",\\r\\n    \\\"quoteSharingAllowed\\\": false\\r\\n   }\\r\\n  }\\r\\n ]\\r\\n}\\r\\n";
        final String SAMPLE_JSON_RESPONSE = "{\n" +
                "   \"kind\":\"books#volumes\",\n" +
                "   \"totalItems\":300,\n" +
                "   \"items\":[\n" +
                "      {\n" +
                "         \"kind\":\"books#volume\",\n" +
                "         \"id\":\"IoW-AAAACAAJ\",\n" +
                "         \"etag\":\"cClI6nNTZVk\",\n" +
                "         \"selfLink\":\"https://www.googleapis.com/books/v1/volumes/IoW-AAAACAAJ\",\n" +
                "         \"volumeInfo\":{\n" +
                "            \"title\":\"Red Rackham's Treasure\",\n" +
                "            \"authors\":[\n" +
                "               \"Hergé\"\n" +
                "            ],\n" +
                "            \"publisher\":\"Egmont Books (UK)\",\n" +
                "            \"publishedDate\":\"2012\",\n" +
                "            \"description\":\"Herg�'s classic comic book creation Tintin is one of the most iconic characters in children's books. These highly collectible editions of the original 24 adventures will delight Tintin fans old and new. Perfect for lovers of graphic novels, mysteries and historical adventures. The world's most famous travelling reporter sets out in search of Red Rackham's treasure. Determined to find the treasure of the notorious pirate Red Rackham, Tintin and Captain Haddock set sail aboard the Sirius to find the shipwreck of the Unicorn. With the help of an ingenious shark-shaped submarine, Tintin follows the clues deep down on this ocean adventure. The Adventures of Tintin are among the best books for readers aged 8 and up. Herg� (Georges Remi) was born in Brussels in 1907. Over the course of 54 years he completed over 20 titles in The Adventures of Tintin series, which is now considered to be one of the greatest, if not the greatest, comics series of all time. Have you collected all 24 graphic novel adventures? Tintin in the Land of the Soviets Tintin in the Congo Tintin in America Tintin: Cigars of the Pharaoh Tintin: The Blue Lotus Tintin: The Broken Ear Tintin: The Black Island Tintin: King Ottakar's Sceptre Tintin: The Crab with the Golden Claws Tintin: The Shooting Star Tintin: The Secret of the Unicorn Tintin: Red Rackham's Treasure Tintin: The Seven Crystal Balls Tintin: Prisoners of the Sun Tintin: Land of Black Gold Tintin: Destination Moon Tintin: Explorers of the Moon Tintin: The Calculus Affair Tintin: The Red Sea Sharks Tintin in Tibet Tintin: The Castafiore Emerald Tintin: Flight 714 to Sydney The Adventures of Tintin and the Picaros Tintin and Alph-Art\",\n" +
                "            \"industryIdentifiers\":[\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_10\",\n" +
                "                  \"identifier\":\"1405206233\"\n" +
                "               },\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_13\",\n" +
                "                  \"identifier\":\"9781405206235\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"readingModes\":{\n" +
                "               \"text\":false,\n" +
                "               \"image\":false\n" +
                "            },\n" +
                "            \"pageCount\":62,\n" +
                "            \"printType\":\"BOOK\",\n" +
                "            \"categories\":[\n" +
                "               \"Adventure\"\n" +
                "            ],\n" +
                "            \"averageRating\":5.0,\n" +
                "            \"ratingsCount\":2,\n" +
                "            \"maturityRating\":\"NOT_MATURE\",\n" +
                "            \"allowAnonLogging\":false,\n" +
                "            \"contentVersion\":\"preview-1.0.0\",\n" +
                "            \"panelizationSummary\":{\n" +
                "               \"containsEpubBubbles\":false,\n" +
                "               \"containsImageBubbles\":false\n" +
                "            },\n" +
                "            \"imageLinks\":{\n" +
                "               \"smallThumbnail\":\"http://books.google.com/books/content?id=IoW-AAAACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api\",\n" +
                "               \"thumbnail\":\"http://books.google.com/books/content?id=IoW-AAAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"\n" +
                "            },\n" +
                "            \"language\":\"en\",\n" +
                "            \"previewLink\":\"http://books.google.co.in/books?id=IoW-AAAACAAJ&dq=subject:adventure&hl=&cd=1&source=gbs_api\",\n" +
                "            \"infoLink\":\"http://books.google.co.in/books?id=IoW-AAAACAAJ&dq=subject:adventure&hl=&source=gbs_api\",\n" +
                "            \"canonicalVolumeLink\":\"https://books.google.com/books/about/Red_Rackham_s_Treasure.html?hl=&id=IoW-AAAACAAJ\"\n" +
                "         },\n" +
                "         \"saleInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"saleability\":\"NOT_FOR_SALE\",\n" +
                "            \"isEbook\":false\n" +
                "         },\n" +
                "         \"accessInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"viewability\":\"NO_PAGES\",\n" +
                "            \"embeddable\":false,\n" +
                "            \"publicDomain\":false,\n" +
                "            \"textToSpeechPermission\":\"ALLOWED\",\n" +
                "            \"epub\":{\n" +
                "               \"isAvailable\":false\n" +
                "            },\n" +
                "            \"pdf\":{\n" +
                "               \"isAvailable\":false\n" +
                "            },\n" +
                "            \"webReaderLink\":\"http://play.google.com/books/reader?id=IoW-AAAACAAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "            \"accessViewStatus\":\"NONE\",\n" +
                "            \"quoteSharingAllowed\":false\n" +
                "         }\n" +
                "      },\n" +
                "      {\n" +
                "         \"kind\":\"books#volume\",\n" +
                "         \"id\":\"qYc8AwAAQBAJ\",\n" +
                "         \"etag\":\"28t0dK4YLbA\",\n" +
                "         \"selfLink\":\"https://www.googleapis.com/books/v1/volumes/qYc8AwAAQBAJ\",\n" +
                "         \"volumeInfo\":{\n" +
                "            \"title\":\"You Choose 2: Mayhem at Magic School\",\n" +
                "            \"authors\":[\n" +
                "               \"George Ivanoff\"\n" +
                "            ],\n" +
                "            \"publisher\":\"Random House Australia\",\n" +
                "            \"publishedDate\":\"2014\",\n" +
                "            \"description\":\"Abrand-new series of interactive novels for the highly adventurous. Read if you dare! Mistakes will cost you dearly! YOU CHOOSE...Supreme ruler of the world or misfortune for life! You are an ordinary kid... or so you think. Strange things start to happen. You make a rabbit appear from underneath your teacher's hat. Then you dream about a mystical diamond and a mysterious old woman with long white hair... It turns out you have magical powers. Do you try to keep your talents hidden or do you go off to Magic School?\",\n" +
                "            \"industryIdentifiers\":[\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_13\",\n" +
                "                  \"identifier\":\"9780857983848\"\n" +
                "               },\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_10\",\n" +
                "                  \"identifier\":\"0857983849\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"readingModes\":{\n" +
                "               \"text\":false,\n" +
                "               \"image\":false\n" +
                "            },\n" +
                "            \"pageCount\":160,\n" +
                "            \"printType\":\"BOOK\",\n" +
                "            \"categories\":[\n" +
                "               \"Juvenile Fiction\"\n" +
                "            ],\n" +
                "            \"maturityRating\":\"NOT_MATURE\",\n" +
                "            \"allowAnonLogging\":false,\n" +
                "            \"contentVersion\":\"preview-1.0.0\",\n" +
                "            \"imageLinks\":{\n" +
                "               \"smallThumbnail\":\"http://books.google.com/books/content?id=qYc8AwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "               \"thumbnail\":\"http://books.google.com/books/content?id=qYc8AwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "            },\n" +
                "            \"language\":\"en\",\n" +
                "            \"previewLink\":\"http://books.google.co.in/books?id=qYc8AwAAQBAJ&printsec=frontcover&dq=subject:adventure&hl=&cd=2&source=gbs_api\",\n" +
                "            \"infoLink\":\"http://books.google.co.in/books?id=qYc8AwAAQBAJ&dq=subject:adventure&hl=&source=gbs_api\",\n" +
                "            \"canonicalVolumeLink\":\"https://books.google.com/books/about/You_Choose_2_Mayhem_at_Magic_School.html?hl=&id=qYc8AwAAQBAJ\"\n" +
                "         },\n" +
                "         \"saleInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"saleability\":\"NOT_FOR_SALE\",\n" +
                "            \"isEbook\":false\n" +
                "         },\n" +
                "         \"accessInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"viewability\":\"PARTIAL\",\n" +
                "            \"embeddable\":true,\n" +
                "            \"publicDomain\":false,\n" +
                "            \"textToSpeechPermission\":\"ALLOWED\",\n" +
                "            \"epub\":{\n" +
                "               \"isAvailable\":false\n" +
                "            },\n" +
                "            \"pdf\":{\n" +
                "               \"isAvailable\":false\n" +
                "            },\n" +
                "            \"webReaderLink\":\"http://play.google.com/books/reader?id=qYc8AwAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "            \"accessViewStatus\":\"SAMPLE\",\n" +
                "            \"quoteSharingAllowed\":false\n" +
                "         }\n" +
                "      },\n" +
                "      {\n" +
                "         \"kind\":\"books#volume\",\n" +
                "         \"id\":\"CQ0QuhLX7pIC\",\n" +
                "         \"etag\":\"2r5lGb5nBSk\",\n" +
                "         \"selfLink\":\"https://www.googleapis.com/books/v1/volumes/CQ0QuhLX7pIC\",\n" +
                "         \"volumeInfo\":{\n" +
                "            \"title\":\"Woodsong\",\n" +
                "            \"authors\":[\n" +
                "               \"Gary Paulsen\"\n" +
                "            ],\n" +
                "            \"publisher\":\"Simon and Schuster\",\n" +
                "            \"publishedDate\":\"2007-05-08\",\n" +
                "            \"description\":\"The author describes his love for the natural world, his involvement in dogsledding, and his experiences taking part in the Iditarod, the 1,180-mile dogsled race across Alaska.\",\n" +
                "            \"industryIdentifiers\":[\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_13\",\n" +
                "                  \"identifier\":\"9781416939399\"\n" +
                "               },\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_10\",\n" +
                "                  \"identifier\":\"1416939393\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"readingModes\":{\n" +
                "               \"text\":false,\n" +
                "               \"image\":false\n" +
                "            },\n" +
                "            \"pageCount\":144,\n" +
                "            \"printType\":\"BOOK\",\n" +
                "            \"categories\":[\n" +
                "               \"Juvenile Nonfiction\"\n" +
                "            ],\n" +
                "            \"averageRating\":3.5,\n" +
                "            \"ratingsCount\":26,\n" +
                "            \"maturityRating\":\"NOT_MATURE\",\n" +
                "            \"allowAnonLogging\":false,\n" +
                "            \"contentVersion\":\"0.2.0.0.preview.0\",\n" +
                "            \"imageLinks\":{\n" +
                "               \"smallThumbnail\":\"http://books.google.com/books/content?id=CQ0QuhLX7pIC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "               \"thumbnail\":\"http://books.google.com/books/content?id=CQ0QuhLX7pIC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "            },\n" +
                "            \"language\":\"en\",\n" +
                "            \"previewLink\":\"http://books.google.co.in/books?id=CQ0QuhLX7pIC&printsec=frontcover&dq=subject:adventure&hl=&cd=3&source=gbs_api\",\n" +
                "            \"infoLink\":\"http://books.google.co.in/books?id=CQ0QuhLX7pIC&dq=subject:adventure&hl=&source=gbs_api\",\n" +
                "            \"canonicalVolumeLink\":\"https://books.google.com/books/about/Woodsong.html?hl=&id=CQ0QuhLX7pIC\"\n" +
                "         },\n" +
                "         \"saleInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"saleability\":\"NOT_FOR_SALE\",\n" +
                "            \"isEbook\":false\n" +
                "         },\n" +
                "         \"accessInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"viewability\":\"PARTIAL\",\n" +
                "            \"embeddable\":true,\n" +
                "            \"publicDomain\":false,\n" +
                "            \"textToSpeechPermission\":\"ALLOWED_FOR_ACCESSIBILITY\",\n" +
                "            \"epub\":{\n" +
                "               \"isAvailable\":false\n" +
                "            },\n" +
                "            \"pdf\":{\n" +
                "               \"isAvailable\":false\n" +
                "            },\n" +
                "            \"webReaderLink\":\"http://play.google.com/books/reader?id=CQ0QuhLX7pIC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "            \"accessViewStatus\":\"SAMPLE\",\n" +
                "            \"quoteSharingAllowed\":false\n" +
                "         }\n" +
                "      },\n" +
                "      {\n" +
                "         \"kind\":\"books#volume\",\n" +
                "         \"id\":\"YlmYBgAAQBAJ\",\n" +
                "         \"etag\":\"HIjzX4HgeGw\",\n" +
                "         \"selfLink\":\"https://www.googleapis.com/books/v1/volumes/YlmYBgAAQBAJ\",\n" +
                "         \"volumeInfo\":{\n" +
                "            \"title\":\"The Boy Who Sailed with Blake\",\n" +
                "            \"subtitle\":\"\",\n" +
                "            \"authors\":[\n" +
                "               \"William Henry Giles Kingston\"\n" +
                "            ],\n" +
                "            \"publisher\":\"Library of Alexandria\",\n" +
                "            \"publishedDate\":\"190?\",\n" +
                "            \"description\":\"ÒHark! the bells of Saint MichaelÕs are sending forth a jovial peal!Ó exclaimed Lancelot Kerridge, as he, Dick Harvey, and I were one day on board his boat fishing for mackerel, about two miles off the sea-port town of Lyme. ÒWhat they are saying I should mightily like to know, for depend onÕt itÕs something of importance. Haul in the lines, Ben!Ó he continued, addressing me; Òand, Dick, put an oar out to windward. IÕll take the helm. We shall fetch the Cob by keeping our luff.Ó The wind was off shore, but as we were to the westward of the Cob, and the tide was making in the same direction, we could easily fetch it. The water was smooth, the sea blue and bright as the eyes of sweet Cicely Kerridge, my friend LancelotÕs young sister, while scarcely a cloud dimmed the clear sky overhead. Lyme, then containing but one thousand inhabitants, where my two companions and I lived, is situated in Dorsetshire, near its western border, on the northern shore of a wide bay, formed by the Bill of Portland on the east and the Start Point on the west. Along the coast are several other towns, of which Dartmouth, owing to its excellent harbour, is the most considerable, besides numerous villages, including Charmouth and Uplyme. A line of cliffs of no great height extends away on either side of Lyme, which stands at the bottom of a valley; while beyond it rise the green slopes of Colway and Uplyme, hills overlooking the town. On the eastern side was the house of my father, Captain Roger Bracewell. He had commanded several of the trading ships of Master Humphrey Blake, of Bridgwater, at one time a merchant of renown, and the father of Captain Robert Blake, who had already made his name famous for his gallant defence of PriorÕs Hill when Bristol was besieged by Prince Rupert, until it was yielded in a dastardly fashion by Governor Fiennes.\",\n" +
                "            \"industryIdentifiers\":[\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_13\",\n" +
                "                  \"identifier\":\"9781465584441\"\n" +
                "               },\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_10\",\n" +
                "                  \"identifier\":\"1465584447\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"readingModes\":{\n" +
                "               \"text\":true,\n" +
                "               \"image\":false\n" +
                "            },\n" +
                "            \"pageCount\":164,\n" +
                "            \"printType\":\"BOOK\",\n" +
                "            \"categories\":[\n" +
                "               \"Great Britain\"\n" +
                "            ],\n" +
                "            \"maturityRating\":\"NOT_MATURE\",\n" +
                "            \"allowAnonLogging\":false,\n" +
                "            \"contentVersion\":\"1.1.1.0.preview.2\",\n" +
                "            \"panelizationSummary\":{\n" +
                "               \"containsEpubBubbles\":false,\n" +
                "               \"containsImageBubbles\":false\n" +
                "            },\n" +
                "            \"imageLinks\":{\n" +
                "               \"smallThumbnail\":\"http://books.google.com/books/content?id=YlmYBgAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "               \"thumbnail\":\"http://books.google.com/books/content?id=YlmYBgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "            },\n" +
                "            \"language\":\"en\",\n" +
                "            \"previewLink\":\"http://books.google.co.in/books?id=YlmYBgAAQBAJ&printsec=frontcover&dq=subject:adventure&hl=&cd=4&source=gbs_api\",\n" +
                "            \"infoLink\":\"https://play.google.com/store/books/details?id=YlmYBgAAQBAJ&source=gbs_api\",\n" +
                "            \"canonicalVolumeLink\":\"https://market.android.com/details?id=book-YlmYBgAAQBAJ\"\n" +
                "         },\n" +
                "         \"saleInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"saleability\":\"FOR_SALE\",\n" +
                "            \"isEbook\":true,\n" +
                "            \"listPrice\":{\n" +
                "               \"amount\":350.0,\n" +
                "               \"currencyCode\":\"INR\"\n" +
                "            },\n" +
                "            \"retailPrice\":{\n" +
                "               \"amount\":350.0,\n" +
                "               \"currencyCode\":\"INR\"\n" +
                "            },\n" +
                "            \"buyLink\":\"https://play.google.com/store/books/details?id=YlmYBgAAQBAJ&rdid=book-YlmYBgAAQBAJ&rdot=1&source=gbs_api\",\n" +
                "            \"offers\":[\n" +
                "               {\n" +
                "                  \"finskyOfferType\":1,\n" +
                "                  \"listPrice\":{\n" +
                "                     \"amountInMicros\":3.5E8,\n" +
                "                     \"currencyCode\":\"INR\"\n" +
                "                  },\n" +
                "                  \"retailPrice\":{\n" +
                "                     \"amountInMicros\":3.5E8,\n" +
                "                     \"currencyCode\":\"INR\"\n" +
                "                  }\n" +
                "               }\n" +
                "            ]\n" +
                "         },\n" +
                "         \"accessInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"viewability\":\"PARTIAL\",\n" +
                "            \"embeddable\":true,\n" +
                "            \"publicDomain\":false,\n" +
                "            \"textToSpeechPermission\":\"ALLOWED\",\n" +
                "            \"epub\":{\n" +
                "               \"isAvailable\":true,\n" +
                "               \"acsTokenLink\":\"http://books.google.co.in/books/download/The_Boy_Who_Sailed_with_Blake-sample-epub.acsm?id=YlmYBgAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "            },\n" +
                "            \"pdf\":{\n" +
                "               \"isAvailable\":false\n" +
                "            },\n" +
                "            \"webReaderLink\":\"http://play.google.com/books/reader?id=YlmYBgAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "            \"accessViewStatus\":\"SAMPLE\",\n" +
                "            \"quoteSharingAllowed\":false\n" +
                "         }\n" +
                "      },\n" +
                "      {\n" +
                "         \"kind\":\"books#volume\",\n" +
                "         \"id\":\"4yoXCgAAQBAJ\",\n" +
                "         \"etag\":\"UfaJEImg6VA\",\n" +
                "         \"selfLink\":\"https://www.googleapis.com/books/v1/volumes/4yoXCgAAQBAJ\",\n" +
                "         \"volumeInfo\":{\n" +
                "            \"title\":\"Can You Survive a Virus Outbreak?\",\n" +
                "            \"subtitle\":\"An Interactive Doomsday Adventure\",\n" +
                "            \"authors\":[\n" +
                "               \"Matt Doeden\"\n" +
                "            ],\n" +
                "            \"publisher\":\"Capstone\",\n" +
                "            \"publishedDate\":\"2015-08-01\",\n" +
                "            \"description\":\"\\\"A You Choose adventure about surviving a virus outbreak\\\"--\",\n" +
                "            \"industryIdentifiers\":[\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_13\",\n" +
                "                  \"identifier\":\"9781491458518\"\n" +
                "               },\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_10\",\n" +
                "                  \"identifier\":\"1491458518\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"readingModes\":{\n" +
                "               \"text\":false,\n" +
                "               \"image\":true\n" +
                "            },\n" +
                "            \"pageCount\":112,\n" +
                "            \"printType\":\"BOOK\",\n" +
                "            \"categories\":[\n" +
                "               \"Juvenile Fiction\"\n" +
                "            ],\n" +
                "            \"maturityRating\":\"NOT_MATURE\",\n" +
                "            \"allowAnonLogging\":false,\n" +
                "            \"contentVersion\":\"preview-1.0.0\",\n" +
                "            \"imageLinks\":{\n" +
                "               \"smallThumbnail\":\"http://books.google.com/books/content?id=4yoXCgAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "               \"thumbnail\":\"http://books.google.com/books/content?id=4yoXCgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "            },\n" +
                "            \"language\":\"en\",\n" +
                "            \"previewLink\":\"http://books.google.co.in/books?id=4yoXCgAAQBAJ&printsec=frontcover&dq=subject:adventure&hl=&cd=5&source=gbs_api\",\n" +
                "            \"infoLink\":\"http://books.google.co.in/books?id=4yoXCgAAQBAJ&dq=subject:adventure&hl=&source=gbs_api\",\n" +
                "            \"canonicalVolumeLink\":\"https://books.google.com/books/about/Can_You_Survive_a_Virus_Outbreak.html?hl=&id=4yoXCgAAQBAJ\"\n" +
                "         },\n" +
                "         \"saleInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"saleability\":\"NOT_FOR_SALE\",\n" +
                "            \"isEbook\":false\n" +
                "         },\n" +
                "         \"accessInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"viewability\":\"PARTIAL\",\n" +
                "            \"embeddable\":true,\n" +
                "            \"publicDomain\":false,\n" +
                "            \"textToSpeechPermission\":\"ALLOWED\",\n" +
                "            \"epub\":{\n" +
                "               \"isAvailable\":false\n" +
                "            },\n" +
                "            \"pdf\":{\n" +
                "               \"isAvailable\":false\n" +
                "            },\n" +
                "            \"webReaderLink\":\"http://play.google.com/books/reader?id=4yoXCgAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "            \"accessViewStatus\":\"SAMPLE\",\n" +
                "            \"quoteSharingAllowed\":false\n" +
                "         }\n" +
                "      },\n" +
                "      {\n" +
                "         \"kind\":\"books#volume\",\n" +
                "         \"id\":\"1P3IaTKWQ3oC\",\n" +
                "         \"etag\":\"U31FuEJH17k\",\n" +
                "         \"selfLink\":\"https://www.googleapis.com/books/v1/volumes/1P3IaTKWQ3oC\",\n" +
                "         \"volumeInfo\":{\n" +
                "            \"title\":\"One False Note\",\n" +
                "            \"authors\":[\n" +
                "               \"Gordon Korman\"\n" +
                "            ],\n" +
                "            \"publisher\":\"Scholastic Inc.\",\n" +
                "            \"publishedDate\":\"2008\",\n" +
                "            \"description\":\"Amy and Dan Cahill's quest to find the million dollars takes them to Vienna, where they must outwit their power-hungry relatives as they seek to solve a clue involving Mozart.\",\n" +
                "            \"industryIdentifiers\":[\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_13\",\n" +
                "                  \"identifier\":\"9780545060424\"\n" +
                "               },\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_10\",\n" +
                "                  \"identifier\":\"0545060427\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"readingModes\":{\n" +
                "               \"text\":false,\n" +
                "               \"image\":true\n" +
                "            },\n" +
                "            \"pageCount\":174,\n" +
                "            \"printType\":\"BOOK\",\n" +
                "            \"categories\":[\n" +
                "               \"Juvenile Fiction\"\n" +
                "            ],\n" +
                "            \"averageRating\":4.0,\n" +
                "            \"ratingsCount\":61,\n" +
                "            \"maturityRating\":\"NOT_MATURE\",\n" +
                "            \"allowAnonLogging\":false,\n" +
                "            \"contentVersion\":\"0.0.1.0.preview.1\",\n" +
                "            \"imageLinks\":{\n" +
                "               \"smallThumbnail\":\"http://books.google.com/books/content?id=1P3IaTKWQ3oC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "               \"thumbnail\":\"http://books.google.com/books/content?id=1P3IaTKWQ3oC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "            },\n" +
                "            \"language\":\"en\",\n" +
                "            \"previewLink\":\"http://books.google.co.in/books?id=1P3IaTKWQ3oC&printsec=frontcover&dq=subject:adventure&hl=&cd=6&source=gbs_api\",\n" +
                "            \"infoLink\":\"http://books.google.co.in/books?id=1P3IaTKWQ3oC&dq=subject:adventure&hl=&source=gbs_api\",\n" +
                "            \"canonicalVolumeLink\":\"https://books.google.com/books/about/One_False_Note.html?hl=&id=1P3IaTKWQ3oC\"\n" +
                "         },\n" +
                "         \"saleInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"saleability\":\"NOT_FOR_SALE\",\n" +
                "            \"isEbook\":false\n" +
                "         },\n" +
                "         \"accessInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"viewability\":\"PARTIAL\",\n" +
                "            \"embeddable\":true,\n" +
                "            \"publicDomain\":false,\n" +
                "            \"textToSpeechPermission\":\"ALLOWED_FOR_ACCESSIBILITY\",\n" +
                "            \"epub\":{\n" +
                "               \"isAvailable\":false\n" +
                "            },\n" +
                "            \"pdf\":{\n" +
                "               \"isAvailable\":true,\n" +
                "               \"acsTokenLink\":\"http://books.google.co.in/books/download/One_False_Note-sample-pdf.acsm?id=1P3IaTKWQ3oC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "            },\n" +
                "            \"webReaderLink\":\"http://play.google.com/books/reader?id=1P3IaTKWQ3oC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "            \"accessViewStatus\":\"SAMPLE\",\n" +
                "            \"quoteSharingAllowed\":false\n" +
                "         }\n" +
                "      },\n" +
                "      {\n" +
                "         \"kind\":\"books#volume\",\n" +
                "         \"id\":\"x0cvCwAAQBAJ\",\n" +
                "         \"etag\":\"7/wcFZGE+0w\",\n" +
                "         \"selfLink\":\"https://www.googleapis.com/books/v1/volumes/x0cvCwAAQBAJ\",\n" +
                "         \"volumeInfo\":{\n" +
                "            \"title\":\"Can You Survive in a Dystopia?\",\n" +
                "            \"subtitle\":\"An Interactive Doomsday Adventure\",\n" +
                "            \"authors\":[\n" +
                "               \"Anthony Wacholtz\"\n" +
                "            ],\n" +
                "            \"publisher\":\"Capstone\",\n" +
                "            \"publishedDate\":\"2016-01-01\",\n" +
                "            \"description\":\"The world is a shell of its former self. Most of the world's population is gone. You're one of the few lucky survivors, but can you trust the people that remain? Or will you face the bleak future on your own? When YOU CHOOSE what to do next, the choices you make could mean the difference between life and death.? How long can you survive in a dystopia?\",\n" +
                "            \"industryIdentifiers\":[\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_13\",\n" +
                "                  \"identifier\":\"9781491481103\"\n" +
                "               },\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_10\",\n" +
                "                  \"identifier\":\"1491481102\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"readingModes\":{\n" +
                "               \"text\":false,\n" +
                "               \"image\":true\n" +
                "            },\n" +
                "            \"pageCount\":112,\n" +
                "            \"printType\":\"BOOK\",\n" +
                "            \"categories\":[\n" +
                "               \"Juvenile Fiction\"\n" +
                "            ],\n" +
                "            \"maturityRating\":\"NOT_MATURE\",\n" +
                "            \"allowAnonLogging\":false,\n" +
                "            \"contentVersion\":\"preview-1.0.0\",\n" +
                "            \"imageLinks\":{\n" +
                "               \"smallThumbnail\":\"   \",\n" +
                "               \"thumbnail\":\"http://books.google.com/books/content?id=x0cvCwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "            },\n" +
                "            \"language\":\"en\",\n" +
                "            \"previewLink\":\"http://books.google.co.in/books?id=x0cvCwAAQBAJ&printsec=frontcover&dq=subject:adventure&hl=&cd=7&source=gbs_api\",\n" +
                "            \"infoLink\":\"http://books.google.co.in/books?id=x0cvCwAAQBAJ&dq=subject:adventure&hl=&source=gbs_api\",\n" +
                "            \"canonicalVolumeLink\":\"https://books.google.com/books/about/Can_You_Survive_in_a_Dystopia.html?hl=&id=x0cvCwAAQBAJ\"\n" +
                "         },\n" +
                "         \"saleInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"saleability\":\"NOT_FOR_SALE\",\n" +
                "            \"isEbook\":false\n" +
                "         },\n" +
                "         \"accessInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"viewability\":\"PARTIAL\",\n" +
                "            \"embeddable\":true,\n" +
                "            \"publicDomain\":false,\n" +
                "            \"textToSpeechPermission\":\"ALLOWED\",\n" +
                "            \"epub\":{\n" +
                "               \"isAvailable\":false\n" +
                "            },\n" +
                "            \"pdf\":{\n" +
                "               \"isAvailable\":false\n" +
                "            },\n" +
                "            \"webReaderLink\":\"http://play.google.com/books/reader?id=x0cvCwAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "            \"accessViewStatus\":\"SAMPLE\",\n" +
                "            \"quoteSharingAllowed\":false\n" +
                "         }\n" +
                "      },\n" +
                "      {\n" +
                "         \"kind\":\"books#volume\",\n" +
                "         \"id\":\"QVs9AwAAQBAJ\",\n" +
                "         \"etag\":\"pst4n+zDKFY\",\n" +
                "         \"selfLink\":\"https://www.googleapis.com/books/v1/volumes/QVs9AwAAQBAJ\",\n" +
                "         \"volumeInfo\":{\n" +
                "            \"title\":\"The Wrath of the Lizard Lord\",\n" +
                "            \"authors\":[\n" +
                "               \"Jon Mayhew\"\n" +
                "            ],\n" +
                "            \"publisher\":\"A&C Black\",\n" +
                "            \"publishedDate\":\"2014\",\n" +
                "            \"description\":\"Dakkar is plunged into a new and perilous adventure as history and fantasy collide for a breathtaking showdown in a mysterious world at the centre of the earth.\",\n" +
                "            \"industryIdentifiers\":[\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_13\",\n" +
                "                  \"identifier\":\"9781408826324\"\n" +
                "               },\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_10\",\n" +
                "                  \"identifier\":\"1408826321\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"readingModes\":{\n" +
                "               \"text\":false,\n" +
                "               \"image\":true\n" +
                "            },\n" +
                "            \"pageCount\":263,\n" +
                "            \"printType\":\"BOOK\",\n" +
                "            \"categories\":[\n" +
                "               \"Adventure\"\n" +
                "            ],\n" +
                "            \"maturityRating\":\"NOT_MATURE\",\n" +
                "            \"allowAnonLogging\":false,\n" +
                "            \"contentVersion\":\"preview-1.0.0\",\n" +
                "            \"imageLinks\":{\n" +
                "               \"smallThumbnail\":\"http://books.google.com/books/content?id=QVs9AwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "               \"thumbnail\":\"http://books.google.com/books/content?id=QVs9AwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "            },\n" +
                "            \"language\":\"en\",\n" +
                "            \"previewLink\":\"http://books.google.co.in/books?id=QVs9AwAAQBAJ&printsec=frontcover&dq=subject:adventure&hl=&cd=8&source=gbs_api\",\n" +
                "            \"infoLink\":\"http://books.google.co.in/books?id=QVs9AwAAQBAJ&dq=subject:adventure&hl=&source=gbs_api\",\n" +
                "            \"canonicalVolumeLink\":\"https://books.google.com/books/about/The_Wrath_of_the_Lizard_Lord.html?hl=&id=QVs9AwAAQBAJ\"\n" +
                "         },\n" +
                "         \"saleInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"saleability\":\"NOT_FOR_SALE\",\n" +
                "            \"isEbook\":false\n" +
                "         },\n" +
                "         \"accessInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"viewability\":\"PARTIAL\",\n" +
                "            \"embeddable\":true,\n" +
                "            \"publicDomain\":false,\n" +
                "            \"textToSpeechPermission\":\"ALLOWED\",\n" +
                "            \"epub\":{\n" +
                "               \"isAvailable\":false\n" +
                "            },\n" +
                "            \"pdf\":{\n" +
                "               \"isAvailable\":false\n" +
                "            },\n" +
                "            \"webReaderLink\":\"http://play.google.com/books/reader?id=QVs9AwAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "            \"accessViewStatus\":\"SAMPLE\",\n" +
                "            \"quoteSharingAllowed\":false\n" +
                "         }\n" +
                "      },\n" +
                "      {\n" +
                "         \"kind\":\"books#volume\",\n" +
                "         \"id\":\"AyznSi4MMm4C\",\n" +
                "         \"etag\":\"1xvmbd6COcs\",\n" +
                "         \"selfLink\":\"https://www.googleapis.com/books/v1/volumes/AyznSi4MMm4C\",\n" +
                "         \"volumeInfo\":{\n" +
                "            \"title\":\"Dogsong\",\n" +
                "            \"authors\":[\n" +
                "               \"Gary Paulsen\"\n" +
                "            ],\n" +
                "            \"publisher\":\"Simon and Schuster\",\n" +
                "            \"publishedDate\":\"2007-05-08\",\n" +
                "            \"description\":\"A fourteen-year-old Eskimo boy who feels at odds with aspects of modern life takes a 1400-mile journey by dog sled across ice, tundra, and mountains seeking his own \\\"song\\\" of himself.\",\n" +
                "            \"industryIdentifiers\":[\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_13\",\n" +
                "                  \"identifier\":\"9781416939191\"\n" +
                "               },\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_10\",\n" +
                "                  \"identifier\":\"1416939199\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"readingModes\":{\n" +
                "               \"text\":false,\n" +
                "               \"image\":false\n" +
                "            },\n" +
                "            \"pageCount\":192,\n" +
                "            \"printType\":\"BOOK\",\n" +
                "            \"categories\":[\n" +
                "               \"Juvenile Fiction\"\n" +
                "            ],\n" +
                "            \"averageRating\":3.5,\n" +
                "            \"ratingsCount\":15,\n" +
                "            \"maturityRating\":\"NOT_MATURE\",\n" +
                "            \"allowAnonLogging\":false,\n" +
                "            \"contentVersion\":\"preview-1.0.0\",\n" +
                "            \"imageLinks\":{\n" +
                "               \"smallThumbnail\":\"http://books.google.com/books/content?id=AyznSi4MMm4C&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "               \"thumbnail\":\"http://books.google.com/books/content?id=AyznSi4MMm4C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "            },\n" +
                "            \"language\":\"en\",\n" +
                "            \"previewLink\":\"http://books.google.co.in/books?id=AyznSi4MMm4C&printsec=frontcover&dq=subject:adventure&hl=&cd=9&source=gbs_api\",\n" +
                "            \"infoLink\":\"http://books.google.co.in/books?id=AyznSi4MMm4C&dq=subject:adventure&hl=&source=gbs_api\",\n" +
                "            \"canonicalVolumeLink\":\"https://books.google.com/books/about/Dogsong.html?hl=&id=AyznSi4MMm4C\"\n" +
                "         },\n" +
                "         \"saleInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"saleability\":\"NOT_FOR_SALE\",\n" +
                "            \"isEbook\":false\n" +
                "         },\n" +
                "         \"accessInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"viewability\":\"PARTIAL\",\n" +
                "            \"embeddable\":true,\n" +
                "            \"publicDomain\":false,\n" +
                "            \"textToSpeechPermission\":\"ALLOWED_FOR_ACCESSIBILITY\",\n" +
                "            \"epub\":{\n" +
                "               \"isAvailable\":false\n" +
                "            },\n" +
                "            \"pdf\":{\n" +
                "               \"isAvailable\":false\n" +
                "            },\n" +
                "            \"webReaderLink\":\"http://play.google.com/books/reader?id=AyznSi4MMm4C&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "            \"accessViewStatus\":\"SAMPLE\",\n" +
                "            \"quoteSharingAllowed\":false\n" +
                "         }\n" +
                "      },\n" +
                "      {\n" +
                "         \"kind\":\"books#volume\",\n" +
                "         \"id\":\"Oi9vfDvIuBUC\",\n" +
                "         \"etag\":\"Z+B3luo3W4g\",\n" +
                "         \"selfLink\":\"https://www.googleapis.com/books/v1/volumes/Oi9vfDvIuBUC\",\n" +
                "         \"volumeInfo\":{\n" +
                "            \"title\":\"Treasure Island\",\n" +
                "            \"authors\":[\n" +
                "               \"Robert Louis Stevenson\"\n" +
                "            ],\n" +
                "            \"publisher\":\"Collector's Library\",\n" +
                "            \"publishedDate\":\"2004\",\n" +
                "            \"description\":\"Treasure Island is one of the best-loved children's stories of all time but is a wonderful adventure story that can be enjoyed at any age.When Jim Hawkins finds a pirate's treasure map in an old sailor's sea trunk the local doctor and squire take him with them to find the island and the treasure. But Long John Silver, with his missing leg and talking parrot, has his own ideas about who should find the treasure.Illustrated by H M Brock, with an Afterword by Sam Gilpin.\",\n" +
                "            \"industryIdentifiers\":[\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_10\",\n" +
                "                  \"identifier\":\"1904633447\"\n" +
                "               },\n" +
                "               {\n" +
                "                  \"type\":\"ISBN_13\",\n" +
                "                  \"identifier\":\"9781904633440\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"readingModes\":{\n" +
                "               \"text\":true,\n" +
                "               \"image\":true\n" +
                "            },\n" +
                "            \"pageCount\":302,\n" +
                "            \"printType\":\"BOOK\",\n" +
                "            \"categories\":[\n" +
                "               \"Fiction\"\n" +
                "            ],\n" +
                "            \"averageRating\":3.0,\n" +
                "            \"ratingsCount\":3,\n" +
                "            \"maturityRating\":\"NOT_MATURE\",\n" +
                "            \"allowAnonLogging\":false,\n" +
                "            \"contentVersion\":\"3.6.3.0.preview.3\",\n" +
                "            \"imageLinks\":{\n" +
                "               \"smallThumbnail\":\"http://books.google.com/books/content?id=Oi9vfDvIuBUC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "               \"thumbnail\":\"http://books.google.com/books/content?id=Oi9vfDvIuBUC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "            },\n" +
                "            \"language\":\"en\",\n" +
                "            \"previewLink\":\"http://books.google.co.in/books?id=Oi9vfDvIuBUC&printsec=frontcover&dq=subject:adventure&hl=&cd=10&source=gbs_api\",\n" +
                "            \"infoLink\":\"http://books.google.co.in/books?id=Oi9vfDvIuBUC&dq=subject:adventure&hl=&source=gbs_api\",\n" +
                "            \"canonicalVolumeLink\":\"https://books.google.com/books/about/Treasure_Island.html?hl=&id=Oi9vfDvIuBUC\"\n" +
                "         },\n" +
                "         \"saleInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"saleability\":\"NOT_FOR_SALE\",\n" +
                "            \"isEbook\":false\n" +
                "         },\n" +
                "         \"accessInfo\":{\n" +
                "            \"country\":\"IN\",\n" +
                "            \"viewability\":\"PARTIAL\",\n" +
                "            \"embeddable\":true,\n" +
                "            \"publicDomain\":false,\n" +
                "            \"textToSpeechPermission\":\"ALLOWED\",\n" +
                "            \"epub\":{\n" +
                "               \"isAvailable\":true,\n" +
                "               \"acsTokenLink\":\"http://books.google.co.in/books/download/Treasure_Island-sample-epub.acsm?id=Oi9vfDvIuBUC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "            },\n" +
                "            \"pdf\":{\n" +
                "               \"isAvailable\":false\n" +
                "            },\n" +
                "            \"webReaderLink\":\"http://play.google.com/books/reader?id=Oi9vfDvIuBUC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "            \"accessViewStatus\":\"SAMPLE\",\n" +
                "            \"quoteSharingAllowed\":false\n" +
                "         }\n" +
                "      }\n" +
                "   ]\n" +
                "}";

        ArrayList<Book> books = null;

        try {

            JSONObject root = new JSONObject(SAMPLE_JSON_RESPONSE);
            JSONArray items = root.getJSONArray("items");
            for(int  i = 0; i < items.length(); i++){

                String title = "";
                ArrayList<String> authors = new ArrayList<>();
                String publish_date = "";
                String description = "";
                String info_link = "";
                Bitmap image_bitmap = null;
                String image_url = "";

                JSONObject nthItem = items.getJSONObject(i);

                JSONObject volume_info = nthItem.getJSONObject("volumeInfo");

                // extracting the title of the volume:
                title += volume_info.getString("title");

                /*
                 * extracting authors of the volume
                 * using for loop
                 * (since the name of the authors
                 *  is stored in an array)
                 */
                JSONArray authors_array = volume_info.getJSONArray("authors");
                authors.add(authors_array.get(0).toString());
//                for(int j = 0; j < authors_array.length(); j++){
//
//                    authors.add(authors_array.get(j).toString());
//
//                }

                // extracting the date the volume was published
                // TODO : converth the String publish date to Integer
                publish_date += volume_info.getString("publishedDate");

                // extracting the description of the volume
                description += volume_info.getString("description");

                // extracting link to access further info
                // regarding the volume
                // TODO : find a better way of using the link
                info_link += volume_info.getString("infoLink");

                // extracting image bitmap from the downloadable link:
                JSONObject image_links = volume_info.getJSONObject("imageLinks");
                image_url = image_links.getString("smallThumbnail");
                ImageAsyncTask imageAsyncTask = new ImageAsyncTask();
                try {
                    image_bitmap = imageAsyncTask.execute(image_url).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

                // converting authors jsonarray in to array list:
                ArrayList<String> authors_array_list = new ArrayList<>();
                for (int k = 0; k < authors_array.length(); k++){
                    authors_array_list.add(authors_array.get(k).toString());
                }

                books.add(new Book(title, authors_array_list, publish_date, description, info_link, image_bitmap));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        // books = QueryUtils.extractInfoFromJSON(SAMPLE_JSON_RESPONSE);

        BooksListViewAdapter adapter = new BooksListViewAdapter(BooksListView.this, books);
        booksLV.setAdapter(adapter);

    }
    private static class ImageAsyncTask extends AsyncTask<String, Void, Bitmap>{

        Bitmap sync_image_bitmap;

        @Override
        protected Bitmap doInBackground(String... params) {
            try {

                InputStream input = new java.net.URL(params[0]).openStream();
                sync_image_bitmap = BitmapFactory.decodeStream(input);

            } catch (IOException e) {

                e.printStackTrace();

            }
            return sync_image_bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
        }
    }
}
