package com.example.anonymous.books;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class BookList extends AppCompatActivity {

    public ListView booksListView;
    public ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        final String SAMPLE_JSON_RESPONSE = "{\n" +
                " \"kind\": \"books#volumes\",\n" +
                " \"totalItems\": 596,\n" +
                " \"items\": [\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"h4ByBu1TQDMC\",\n" +
                "   \"etag\": \"2oKVqCJTI3o\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/h4ByBu1TQDMC\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"Shotgun City: Melbourne's Gangland Killings\",\n" +
                "    \"authors\": [\n" +
                "     \"Paul Anderson\"\n" +
                "    ],\n" +
                "    \"publisher\": \"Hardie Grant Publishing\",\n" +
                "    \"publishedDate\": \"2004-10-01\",\n" +
                "    \"description\": \"The execution of self-styled gangster Alphonse Gangitano in January 1998\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9781742734422\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"1742734421\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": true,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 250,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"True Crime\"\n" +
                "    ],\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": true,\n" +
                "    \"contentVersion\": \"0.0.2.0.preview.3\",\n" +
                "    \"panelizationSummary\": {\n" +
                "     \"containsEpubBubbles\": false,\n" +
                "     \"containsImageBubbles\": false\n" +
                "    },\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=h4ByBu1TQDMC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=h4ByBu1TQDMC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=h4ByBu1TQDMC&printsec=frontcover&dq=subject:crime&hl=&cd=1&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=h4ByBu1TQDMC&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Shotgun_City_Melbourne_s_Gangland_Killin.html?hl=&id=h4ByBu1TQDMC\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": true,\n" +
                "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Shotgun_City_Melbourne_s_Gangland_Killin-sample-epub.acsm?id=h4ByBu1TQDMC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": true,\n" +
                "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Shotgun_City_Melbourne_s_Gangland_Killin-sample-pdf.acsm?id=h4ByBu1TQDMC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=h4ByBu1TQDMC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"bPMfAQAAIAAJ\",\n" +
                "   \"etag\": \"RwHP6MC6ysU\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/bPMfAQAAIAAJ\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"The Nothing Man\",\n" +
                "    \"authors\": [\n" +
                "     \"Jim Thompson\"\n" +
                "    ],\n" +
                "    \"publisher\": \"Vintage\",\n" +
                "    \"publishedDate\": \"1954\",\n" +
                "    \"description\": \"After a wartime injury leaves him with a bitter and incomplete life, Clinton Brown turns to drinking and then to the destruction of those who make the mistake of invading his lonely world, as his sole consolation. Reprint.\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"OTHER\",\n" +
                "      \"identifier\": \"STANFORD:36105012159310\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": false\n" +
                "    },\n" +
                "    \"pageCount\": 219,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"Fiction\"\n" +
                "    ],\n" +
                "    \"averageRating\": 4.0,\n" +
                "    \"ratingsCount\": 1,\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"0.1.1.0.preview.0\",\n" +
                "    \"panelizationSummary\": {\n" +
                "     \"containsEpubBubbles\": false,\n" +
                "     \"containsImageBubbles\": false\n" +
                "    },\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=bPMfAQAAIAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=bPMfAQAAIAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=bPMfAQAAIAAJ&dq=subject:crime&hl=&cd=2&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=bPMfAQAAIAAJ&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/The_Nothing_Man.html?hl=&id=bPMfAQAAIAAJ\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"NO_PAGES\",\n" +
                "    \"embeddable\": false,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=bPMfAQAAIAAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"NONE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"whWL6D83FBUC\",\n" +
                "   \"etag\": \"Ntah8CmKBnY\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/whWL6D83FBUC\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"Crime Policy in America\",\n" +
                "    \"subtitle\": \"Laws, Institutions, and Programs\",\n" +
                "    \"authors\": [\n" +
                "     \"Shahid M. Shahidullah\"\n" +
                "    ],\n" +
                "    \"publisher\": \"University Press of America\",\n" +
                "    \"publishedDate\": \"2008\",\n" +
                "    \"description\": \"This book is a systematic examination of the nature of America's crime and criminal justice system as defined by its policy-makers at different times and in disparate contexts of social and political realities. By examining legislative documents and court cases and analyzing federal and state policy developments in such areas as drug crimes, juvenile crimes, sex crimes, and cyber crimes, this book provides a historically embedded and policy relevant understanding of how America's system of criminal justice was born, how it has grown, and where it is going.\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"0761840982\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9780761840985\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": true,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 311,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"Social Science\"\n" +
                "    ],\n" +
                "    \"averageRating\": 5.0,\n" +
                "    \"ratingsCount\": 1,\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"0.0.1.0.preview.3\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=whWL6D83FBUC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=whWL6D83FBUC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=whWL6D83FBUC&printsec=frontcover&dq=subject:crime&hl=&cd=3&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=whWL6D83FBUC&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Crime_Policy_in_America.html?hl=&id=whWL6D83FBUC\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": true,\n" +
                "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Crime_Policy_in_America-sample-epub.acsm?id=whWL6D83FBUC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": true,\n" +
                "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Crime_Policy_in_America-sample-pdf.acsm?id=whWL6D83FBUC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=whWL6D83FBUC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"NEnUqBFrHgoC\",\n" +
                "   \"etag\": \"+51DIef15ns\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/NEnUqBFrHgoC\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"In Terror and in Silence\",\n" +
                "    \"subtitle\": \"An Investigation Into Safety Levels and Standards at Petrol Stations ; Petrol Station 5 Project, December 2002\",\n" +
                "    \"authors\": [\n" +
                "     \"Adrian Hadland\"\n" +
                "    ],\n" +
                "    \"publisher\": \"HSRC Press\",\n" +
                "    \"publishedDate\": \"2002\",\n" +
                "    \"description\": \"In response to the murder of five Cape Town petrol station attendants in June 2002, a major investigation was conducted into crime and safety at South African petrol stations.\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"0796920087\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9780796920089\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 50,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"Crime\"\n" +
                "    ],\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"0.1.1.0.preview.1\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=NEnUqBFrHgoC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=NEnUqBFrHgoC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=NEnUqBFrHgoC&printsec=frontcover&dq=subject:crime&hl=&cd=4&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=NEnUqBFrHgoC&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/In_Terror_and_in_Silence.html?hl=&id=NEnUqBFrHgoC\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"ALL_PAGES\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=NEnUqBFrHgoC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"gmPWsVEA_CcC\",\n" +
                "   \"etag\": \"I9wc8EDL7QA\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/gmPWsVEA_CcC\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"Crime Scenes\",\n" +
                "    \"subtitle\": \"Detective Narratives in European Culture Since 1945\",\n" +
                "    \"authors\": [\n" +
                "     \"Anne Mullen\",\n" +
                "     \"Emer O'Beirne\"\n" +
                "    ],\n" +
                "    \"publisher\": \"Rodopi\",\n" +
                "    \"publishedDate\": \"2000\",\n" +
                "    \"description\": \"The essays in this collection are based on papers given at a conference on detective fiction in European culture, held at the University of Exeter in September 1997. The range of topics covered is designed to show not only the presence and variety of narratives of detection across different European countries and their different media (although there is a predictable emphasis on the novel). It also illustrates the fertility of the genre, its openness to a spectrum of readings with different emphases, formal as well as thematic. Approaches to detective fiction have often tended to confine them-selves to 'symptomatic' interpretation, where details of the fictional world represented are used to diagnose a specific set of social preoccupations and priorities operative at the time of writing. Such approaches can yield valuable insights. Nonetheless there is a risk of limiting the value of the genre as a whole solely to its role as a mirror held up to society. In this perspective, issues of structure and style are sidelined, or, if addressed, are praised to the extent that they approach invisibility — concision, spareness, realism are the qualities singled out for praise. The genre also gives much scope for formal innovation — and indeed has often attracted already established 'mainstream' writers and filmmakers for just this reason.The eclectic diversity of the detective narratives considered in this volume reveal the malleability of the traditional constraints of the genre. The essays bear rich testimony to the value of considering the interplay of thematic and structural issues, even in the most apparently unselfconscious and popular (or populist) forms of narrative. The patterns of reassurance, the triumph of intellect and the ordered, rational world 'of old' are now challenged by the need to foreground the problems, ambiguities and uncertainties of the self and of society. The plurality of meanings and the antithetical imperatives explored in these detective narratives confirm that the most recent forms of the genre are not mere palimpsests of their 'golden age' precursors. The subversion of traditional expectations and the implementation of diverse stylistic devices take the genre beyond mere homage and pastiche. The role of the reader/spectator and critic in conferring meaning is a crucial one.\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"9042012331\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9789042012332\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 325,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"Literary Collections\"\n" +
                "    ],\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"0.0.2.0.preview.1\",\n" +
                "    \"panelizationSummary\": {\n" +
                "     \"containsEpubBubbles\": false,\n" +
                "     \"containsImageBubbles\": false\n" +
                "    },\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=gmPWsVEA_CcC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=gmPWsVEA_CcC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=gmPWsVEA_CcC&printsec=frontcover&dq=subject:crime&hl=&cd=5&source=gbs_api\",\n" +
                "    \"infoLink\": \"https://play.google.com/store/books/details?id=gmPWsVEA_CcC&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-gmPWsVEA_CcC\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"FOR_SALE\",\n" +
                "    \"isEbook\": true,\n" +
                "    \"listPrice\": {\n" +
                "     \"amount\": 5546.24,\n" +
                "     \"currencyCode\": \"INR\"\n" +
                "    },\n" +
                "    \"retailPrice\": {\n" +
                "     \"amount\": 5546.24,\n" +
                "     \"currencyCode\": \"INR\"\n" +
                "    },\n" +
                "    \"buyLink\": \"https://play.google.com/store/books/details?id=gmPWsVEA_CcC&rdid=book-gmPWsVEA_CcC&rdot=1&source=gbs_api\",\n" +
                "    \"offers\": [\n" +
                "     {\n" +
                "      \"finskyOfferType\": 1,\n" +
                "      \"listPrice\": {\n" +
                "       \"amountInMicros\": 5.54624E9,\n" +
                "       \"currencyCode\": \"INR\"\n" +
                "      },\n" +
                "      \"retailPrice\": {\n" +
                "       \"amountInMicros\": 5.54624E9,\n" +
                "       \"currencyCode\": \"INR\"\n" +
                "      }\n" +
                "     }\n" +
                "    ]\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": true,\n" +
                "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Crime_Scenes-sample-pdf.acsm?id=gmPWsVEA_CcC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=gmPWsVEA_CcC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"EkHSkXhKrIEC\",\n" +
                "   \"etag\": \"flWOyWhDldQ\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/EkHSkXhKrIEC\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"Witness\",\n" +
                "    \"authors\": [\n" +
                "     \"Anne Cassidy\"\n" +
                "    ],\n" +
                "    \"publisher\": \"Evans Brothers\",\n" +
                "    \"publishedDate\": \"2005\",\n" +
                "    \"description\": \"Todd is always late for everything. Then one day, he's late for school and his life changes for ever. He witnesses a vicious robbery—and recognizes the attacker. Todd knows exactly what he must do, but events conspire against him.\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"0237529246\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9780237529246\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 64,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"Juvenile Nonfiction\"\n" +
                "    ],\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"1.1.1.0.preview.1\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=EkHSkXhKrIEC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=EkHSkXhKrIEC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=EkHSkXhKrIEC&printsec=frontcover&dq=subject:crime&hl=&cd=6&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=EkHSkXhKrIEC&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Witness.html?hl=&id=EkHSkXhKrIEC\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=EkHSkXhKrIEC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"8DiOAgAAQBAJ\",\n" +
                "   \"etag\": \"wkYrUPLvMVg\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/8DiOAgAAQBAJ\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"How Firms Cope with Crime and Violence\",\n" +
                "    \"subtitle\": \"Experiences from Around the World\",\n" +
                "    \"authors\": [\n" +
                "     \"Michael Goldberg\",\n" +
                "     \"Kwang W. Kim\",\n" +
                "     \"Maria Ariano\"\n" +
                "    ],\n" +
                "    \"publisher\": \"World Bank Publications\",\n" +
                "    \"publishedDate\": \"2014-01-23\",\n" +
                "    \"description\": \"Crime and violence inflict high and rising costs on the private sector, equivalent to several points of GDP loss. In light manufacturing, international purchasers quickly shift know-how and capital to less violent destinations and behind the statistics are human costs: lost jobs, working capital spent on security, contraband, fraud and corruption.\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9781464801013\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"1464801010\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 106,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"Business & Economics\"\n" +
                "    ],\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"preview-1.0.0\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=8DiOAgAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=8DiOAgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=8DiOAgAAQBAJ&printsec=frontcover&dq=subject:crime&hl=&cd=7&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=8DiOAgAAQBAJ&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/How_Firms_Cope_with_Crime_and_Violence.html?hl=&id=8DiOAgAAQBAJ\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"ALL_PAGES\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=8DiOAgAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"lgIZPRkSP0sC\",\n" +
                "   \"etag\": \"qY+Cop3bJ6o\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/lgIZPRkSP0sC\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"El delincuente y su patología\",\n" +
                "    \"subtitle\": \"medicina, crimen y sociedad en el positivismo Argentino\",\n" +
                "    \"authors\": [\n" +
                "     \"Rafael Huertas García-Alejo\"\n" +
                "    ],\n" +
                "    \"publisher\": \"Editorial CSIC - CSIC Press\",\n" +
                "    \"publishedDate\": \"1991-01-01\",\n" +
                "    \"description\": \"\\\"Mucho del aspecto monográfico del libro gira en torno a la obra criminológica de José Ingenieros, según se manifiesta en sus trabajos sobre la simulación y en sus teorías de la 'defensa social'. También se examinan las opiniones médicas y psiquiátricas a que dio lugar el fenómeno inmigratorio y sus consecuencias sociales. Todo a lo largo del libro se reitera la afirmación de que los peritajes médicos que se utilizaban para asistir a la justicia, la labor de los asilos, la consideración de los inmigrantes y el saber psiquiátrico en general fueron formas que utilizó la burguesía para ejercer el control social y favorecer el capitalismo. Esa afirmación queda sobreimpuesta al material de estudio, como una imputación más que como una tesis o una hipótesis de trabajo que realmente se demuestra\\\"--Handbook of Latin American Studies, v. 58.\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"8400071905\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9788400071905\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 199,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"Crime\"\n" +
                "    ],\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"0.2.0.0.preview.1\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=lgIZPRkSP0sC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=lgIZPRkSP0sC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"es\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=lgIZPRkSP0sC&printsec=frontcover&dq=subject:crime&hl=&cd=8&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=lgIZPRkSP0sC&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/El_delincuente_y_su_patolog%C3%ADa.html?hl=&id=lgIZPRkSP0sC\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=lgIZPRkSP0sC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"1QpAingDeXkC\",\n" +
                "   \"etag\": \"6QukwO7qdms\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/1QpAingDeXkC\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"Major Barbara\",\n" +
                "    \"authors\": [\n" +
                "     \"George Bernard Shaw\"\n" +
                "    ],\n" +
                "    \"publisher\": \"1st World Publishing\",\n" +
                "    \"publishedDate\": \"2004-09-01\",\n" +
                "    \"description\": \"Edited by Elizabeth T. Forter, this edition of\\\" Major Barbara\\\" for performance and study includes Shaw's complete \\\"Preface.\\\" The text follows Shaw's spelling and punctuation. It also includes a highly regarded twenty-four page introduction, a list of the principal dates in the life of Bernard Shaw, and a selected bibliography.\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"1595402454\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9781595402455\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 153,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"Drama\"\n" +
                "    ],\n" +
                "    \"averageRating\": 3.5,\n" +
                "    \"ratingsCount\": 7,\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"preview-1.0.0\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=1QpAingDeXkC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=1QpAingDeXkC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=1QpAingDeXkC&printsec=frontcover&dq=subject:crime&hl=&cd=9&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=1QpAingDeXkC&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Major_Barbara.html?hl=&id=1QpAingDeXkC\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=1QpAingDeXkC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"koAnv3NRfY8C\",\n" +
                "   \"etag\": \"9u94TN7nBX4\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/koAnv3NRfY8C\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"Criminology and Public Policy\",\n" +
                "    \"subtitle\": \"Putting Theory to Work\",\n" +
                "    \"authors\": [\n" +
                "     \"Hugh Barlow\",\n" +
                "     \"Scott H. Decker\"\n" +
                "    ],\n" +
                "    \"publisher\": \"Temple University Press\",\n" +
                "    \"publishedDate\": \"2010-01-25\",\n" +
                "    \"description\": \"Examines the links between criminological theory and criminal justice policy and practice.\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9781439900086\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"1439900086\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": true,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 306,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"Law\"\n" +
                "    ],\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": true,\n" +
                "    \"contentVersion\": \"0.0.4.0.preview.3\",\n" +
                "    \"panelizationSummary\": {\n" +
                "     \"containsEpubBubbles\": false,\n" +
                "     \"containsImageBubbles\": false\n" +
                "    },\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=koAnv3NRfY8C&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=koAnv3NRfY8C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=koAnv3NRfY8C&printsec=frontcover&dq=subject:crime&hl=&cd=10&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=koAnv3NRfY8C&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Criminology_and_Public_Policy.html?hl=&id=koAnv3NRfY8C\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": true,\n" +
                "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Criminology_and_Public_Policy-sample-epub.acsm?id=koAnv3NRfY8C&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": true,\n" +
                "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Criminology_and_Public_Policy-sample-pdf.acsm?id=koAnv3NRfY8C&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=koAnv3NRfY8C&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"XAdU6T5jIkEC\",\n" +
                "   \"etag\": \"HhMsR4IkFx0\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/XAdU6T5jIkEC\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"The Critical Criminology Companion\",\n" +
                "    \"authors\": [\n" +
                "     \"Thalia Anthony\"\n" +
                "    ],\n" +
                "    \"publisher\": \"Hawkins Press\",\n" +
                "    \"publishedDate\": \"2008\",\n" +
                "    \"description\": \"This companion presents the major debates and issues in critical criminology. It presents new research on crime, policy and the internationalisation of the criminal justice system. It sheds light on traditional debates in critical criminology through a confronting analysis of contemporary developments in criminal justice and criminology. This is the first textbook that brings together the major Australian and New Zealand theorists in critical criminology. The chapters represent the contribution of these authors in both their established work and their recent scholarship. It includes new approaches to theory, methodology, case studies and contemporary issues. It traverses a range of debates including the criminalisation of Indigenous people, ethnic communities, the working class, rural communities and young people from critical perspectives, as well as introduces new concepts of state crime. There is coverage of the developments in the penal system that have responded to globalisation and neo-liberalism, particularly in law and order and anti-terror campaigns. This coverage is counterpoised by portrayals of resistance within the penal system and considerations of restorative justice. The companion is relevant to a broad range of courses and levels of study. It covers the major components of a criminology course through a critical lens. It is a wonderful introduction to the concepts and critiques in criminology, as well as a provocative analysis of the assumptions underpinning the criminal justice system. Students, teachers and scholars in criminology, law and sociology will find this reader an invaluable companion.\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"1876067233\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9781876067236\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 336,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"Crime\"\n" +
                "    ],\n" +
                "    \"averageRating\": 4.0,\n" +
                "    \"ratingsCount\": 4,\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": true,\n" +
                "    \"contentVersion\": \"0.0.3.0.preview.1\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=XAdU6T5jIkEC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=XAdU6T5jIkEC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=XAdU6T5jIkEC&printsec=frontcover&dq=subject:crime&hl=&cd=11&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=XAdU6T5jIkEC&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/The_Critical_Criminology_Companion.html?hl=&id=XAdU6T5jIkEC\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": true,\n" +
                "     \"acsTokenLink\": \"http://books.google.co.in/books/download/The_Critical_Criminology_Companion-sample-pdf.acsm?id=XAdU6T5jIkEC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=XAdU6T5jIkEC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"eQVspPWBtcEC\",\n" +
                "   \"etag\": \"XuZnGQ7hf7Q\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/eQVspPWBtcEC\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"They Died Crawling\",\n" +
                "    \"subtitle\": \"And Other Tales of Cleveland Woe\",\n" +
                "    \"authors\": [\n" +
                "     \"John Stark Bellamy, II\"\n" +
                "    ],\n" +
                "    \"publisher\": \"Gray & Company, Publishers\",\n" +
                "    \"publishedDate\": \"1995\",\n" +
                "    \"description\": \"The foulest crimes and worst in Cleveland history are recounted in these 15 incredible-but-true tales. Each no-holds-barred account into one of this city's most notorious moments, from the 1916 waterworks collapse to the Cleveland Clinic fire to the sensational Sam Sheppard murder trial. These gripping narratives deliver high drama and dark comedy, heroes and villains, obsession, courage, treachery, deceit, fear, and guilt -- all from the streets of Cleveland.\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9781886228030\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"1886228035\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 253,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"History\"\n" +
                "    ],\n" +
                "    \"averageRating\": 5.0,\n" +
                "    \"ratingsCount\": 1,\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"preview-1.0.0\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=eQVspPWBtcEC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=eQVspPWBtcEC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=eQVspPWBtcEC&printsec=frontcover&dq=subject:crime&hl=&cd=12&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=eQVspPWBtcEC&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/They_Died_Crawling.html?hl=&id=eQVspPWBtcEC\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=eQVspPWBtcEC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"ymUoDwAAQBAJ\",\n" +
                "   \"etag\": \"Kb/BFwAGMvk\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/ymUoDwAAQBAJ\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"Violence in Capitalism\",\n" +
                "    \"subtitle\": \"Devaluing Life in an Age of Responsibility\",\n" +
                "    \"authors\": [\n" +
                "     \"James A. Tyner\"\n" +
                "    ],\n" +
                "    \"publisher\": \"U of Nebraska Press\",\n" +
                "    \"publishedDate\": \"2016\",\n" +
                "    \"description\": \"\\\"A geographic reckoning with violence through case studies of how violence affects the dispossessed, women, children, workers, and the environment\\\"--\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9780803253384\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"0803253389\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 255,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"Social Science\"\n" +
                "    ],\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"preview-1.0.0\",\n" +
                "    \"panelizationSummary\": {\n" +
                "     \"containsEpubBubbles\": false,\n" +
                "     \"containsImageBubbles\": false\n" +
                "    },\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=ymUoDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=ymUoDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=ymUoDwAAQBAJ&printsec=frontcover&dq=subject:crime&hl=&cd=13&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=ymUoDwAAQBAJ&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Violence_in_Capitalism.html?hl=&id=ymUoDwAAQBAJ\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=ymUoDwAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"zx422jZOYfkC\",\n" +
                "   \"etag\": \"NQaRPBTF3/E\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/zx422jZOYfkC\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"Criminal Justice in Ireland\",\n" +
                "    \"authors\": [\n" +
                "     \"Paul O'Mahony\"\n" +
                "    ],\n" +
                "    \"publisher\": \"Institute of Public Administration\",\n" +
                "    \"publishedDate\": \"2002\",\n" +
                "    \"description\": \"Comprehensive overview of the Irish criminal justice system, its current problems and its vision for the future. Collection of essays by major office-holders, experienced practitioners, leading academics, legal scholars, sociologists, psychologists, philosophers and educationalists.\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"1902448715\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9781902448718\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 818,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"Courts\"\n" +
                "    ],\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"1.1.1.0.preview.1\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=zx422jZOYfkC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=zx422jZOYfkC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=zx422jZOYfkC&printsec=frontcover&dq=subject:crime&hl=&cd=14&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=zx422jZOYfkC&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Criminal_Justice_in_Ireland.html?hl=&id=zx422jZOYfkC\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=zx422jZOYfkC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"H7Ge7kkOCIkC\",\n" +
                "   \"etag\": \"zfFWcJmukp8\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/H7Ge7kkOCIkC\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"Crime and Violence in Latin America\",\n" +
                "    \"subtitle\": \"Citizen Security, Democracy, and the State\",\n" +
                "    \"authors\": [\n" +
                "     \"H. Hugo Frühling\",\n" +
                "     \"Joseph S. Tulchin\",\n" +
                "     \"Heather Golding\"\n" +
                "    ],\n" +
                "    \"publisher\": \"Woodrow Wilson Center Press\",\n" +
                "    \"publishedDate\": \"2003-06-02\",\n" +
                "    \"description\": \"Offers timely discussion by attorneys, government officials, policy analysts, and academics from the United States and Latin America of the responses of the state, civil society, and the international community to threats of violence and crime.\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"0801873843\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9780801873843\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 284,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"History\"\n" +
                "    ],\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"0.0.1.0.preview.1\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=H7Ge7kkOCIkC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=H7Ge7kkOCIkC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=H7Ge7kkOCIkC&printsec=frontcover&dq=subject:crime&hl=&cd=15&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=H7Ge7kkOCIkC&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Crime_and_Violence_in_Latin_America.html?hl=&id=H7Ge7kkOCIkC\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"ALL_PAGES\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": true,\n" +
                "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Crime_and_Violence_in_Latin_America-sample-pdf.acsm?id=H7Ge7kkOCIkC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=H7Ge7kkOCIkC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"lTSQBi1pgkYC\",\n" +
                "   \"etag\": \"YiESWIO/ZUw\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/lTSQBi1pgkYC\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"Public Criminology?\",\n" +
                "    \"authors\": [\n" +
                "     \"Ian Loader\",\n" +
                "     \"Richard Sparks\"\n" +
                "    ],\n" +
                "    \"publisher\": \"Routledge\",\n" +
                "    \"publishedDate\": \"2010\",\n" +
                "    \"description\": \"What is the role and value of criminology in a democratic society? How do, and how should, its practitioners engage with politics and public policy? How can criminology find a voice in an agitated, insecure and intensely mediated world in which crime and punishment loom large in government agendas and public discourse? What collective good do we want criminological enquiry to promote? In addressing these questions, Ian Loader and Richard Sparks offer a sociological account of how criminologists understand their craft and position themselves in relation to social and political controversies about crime, whether as scientific experts, policy advisors, governmental players, social movement theorists, or lonely prophets. They examine the conditions under which these diverse commitments and affiliations arose, and gained or lost credibility and influence. This forms the basis for a timely articulation of the idea that criminology's overarching public purpose is to contribute to a better politics of crime and its regulation. Public Criminology? offers an original and provocative account of the condition of, and prospects for, criminology which will be of interest not only to those who work in the fields of crime, security and punishment, but to anyone interested in the vexed relationship between social science, public policy and politics.\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9780415445498\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"0415445493\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 196,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"Social Science\"\n" +
                "    ],\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"preview-1.0.0\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=lTSQBi1pgkYC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=lTSQBi1pgkYC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=lTSQBi1pgkYC&printsec=frontcover&dq=subject:crime&hl=&cd=16&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=lTSQBi1pgkYC&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Public_Criminology.html?hl=&id=lTSQBi1pgkYC\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=lTSQBi1pgkYC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"_jCxIawszlQC\",\n" +
                "   \"etag\": \"oKM2DGOy69A\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/_jCxIawszlQC\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"The Criminalization of the State in Africa\",\n" +
                "    \"authors\": [\n" +
                "     \"Jean-François Bayart\",\n" +
                "     \"Stephen Ellis\",\n" +
                "     \"Béatrice Hibou\"\n" +
                "    ],\n" +
                "    \"publisher\": \"James Currey Publishers\",\n" +
                "    \"publishedDate\": \"1999-01-01\",\n" +
                "    \"description\": \"Has Africa moved on from 'classical corruption? What are the political and economic origins of official implication in crime? What are the new frontiers of crime in South Africa?\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"0852558120\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9780852558126\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 126,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"History\"\n" +
                "    ],\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"preview-1.0.0\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=_jCxIawszlQC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=_jCxIawszlQC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=_jCxIawszlQC&printsec=frontcover&dq=subject:crime&hl=&cd=17&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=_jCxIawszlQC&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/The_Criminalization_of_the_State_in_Afri.html?hl=&id=_jCxIawszlQC\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=_jCxIawszlQC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"cuZuwR1GOOkC\",\n" +
                "   \"etag\": \"VpaxB2spjC4\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/cuZuwR1GOOkC\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"Il desiderio della legge\",\n" +
                "    \"authors\": [\n" +
                "     \"Giovambattista Fatelli\"\n" +
                "    ],\n" +
                "    \"publisher\": \"Meltemi Editore srl\",\n" +
                "    \"publishedDate\": \"1999\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9788886479929\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"8886479921\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 167,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"Social Science\"\n" +
                "    ],\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"preview-1.0.0\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=cuZuwR1GOOkC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=cuZuwR1GOOkC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"it\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=cuZuwR1GOOkC&printsec=frontcover&dq=subject:crime&hl=&cd=18&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=cuZuwR1GOOkC&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Il_desiderio_della_legge.html?hl=&id=cuZuwR1GOOkC\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=cuZuwR1GOOkC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"yZa8R5aZRG0C\",\n" +
                "   \"etag\": \"HLRqFJtQ0Qg\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/yZa8R5aZRG0C\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"The Honest Politician's Guide to Crime Control\",\n" +
                "    \"authors\": [\n" +
                "     \"Norval Morris\",\n" +
                "     \"Gordon J. Hawkins\"\n" +
                "    ],\n" +
                "    \"publisher\": \"University of Chicago Press\",\n" +
                "    \"publishedDate\": \"1972-02-15\",\n" +
                "    \"description\": \"Norval Morris and Gordon Hawkins's first premise is that our criminal justice system is a moral busybody, unwisely extended beyond its proper role of protecting persons and property. But they go further and systematically cover the amount, costs, causes, and victims of crime: the reduction of violence; the police; corrections; juvenile delinquency; the function of psychiatry in crime control; organized crime; and the uses of criminological research. On each topic precise recommendations are made and carefully defended.\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"0226539024\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9780226539027\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 279,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"Political Science\"\n" +
                "    ],\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"1.0.2.0.preview.1\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=yZa8R5aZRG0C&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=yZa8R5aZRG0C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=yZa8R5aZRG0C&printsec=frontcover&dq=subject:crime&hl=&cd=19&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=yZa8R5aZRG0C&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/The_Honest_Politician_s_Guide_to_Crime_C.html?hl=&id=yZa8R5aZRG0C\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=yZa8R5aZRG0C&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"asGrIAhuKEgC\",\n" +
                "   \"etag\": \"y2gPspqJdX0\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/asGrIAhuKEgC\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"Violence and Crime in Nineteenth-century England\",\n" +
                "    \"subtitle\": \"The Shadow of Our Refinement\",\n" +
                "    \"authors\": [\n" +
                "     \"John Carter Wood\"\n" +
                "    ],\n" +
                "    \"publisher\": \"Psychology Press\",\n" +
                "    \"publishedDate\": \"2004\",\n" +
                "    \"description\": \"Combining a vivid analysis of criminal records and public debate with theories from cultural studies, anthropology and social geography, this book contributes to current debates in history, criminology and violence studies.\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"0415329051\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9780415329057\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 204,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"History\"\n" +
                "    ],\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"0.0.1.0.preview.1\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=asGrIAhuKEgC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=asGrIAhuKEgC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.co.in/books?id=asGrIAhuKEgC&printsec=frontcover&dq=subject:crime&hl=&cd=20&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.co.in/books?id=asGrIAhuKEgC&dq=subject:crime&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Violence_and_Crime_in_Nineteenth_century.html?hl=&id=asGrIAhuKEgC\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=asGrIAhuKEgC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  }\n" +
                " ]\n" +
                "}\n";

        Intent intent = getIntent();

        booksListView = (ListView) findViewById(R.id.list_view);
        ArrayList<Books> booksArrayList = null;

        new FetchBooksData().execute(intent.getStringExtra("url").toString());
    }

    private class FetchBooksData extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            // These two need to be declared outside the try/catch
            // so that they can be closed in the finally block.
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a string.
            String booksJsonStr = null;

            try {
                // Construct the URL for the OpenWeatherMap query
                // Possible parameters are avaiable at OWM's forecast API page, at
                // http://openweathermap.org/API#forecast
                URL url = new URL(params[0]);

                // Create the request to OpenWeatherMap, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                booksJsonStr = buffer.toString();
                return booksJsonStr;
            } catch (IOException e) {
                e.getStackTrace();
                // If the code didn't successfully get the weather data, there's no point in attemping
                // to parse it.
                return null;
            } finally{
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        e.getStackTrace();
                    }
                }
            }
        }

        @Override
        protected void onPostExecute(String s) {
            ArrayList<Books> books = null;
            try {
                books = QueryUtils.readFromJson(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            adapter = new ListViewAdapter(getApplicationContext(), books);
            booksListView.setAdapter(adapter);
        }
    }
}
