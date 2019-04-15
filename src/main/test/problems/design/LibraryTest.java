package problems.design;

import org.junit.Before;
import org.junit.Test;
import problems.design.library.Library;
import problems.design.library.model.*;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class LibraryTest
{
    private Library library;

    @Before
    public void setUp( )
    {
        library = new Library( );
        library = spy( library );

        setUpLibrary( );
        setUpMediaEntitiesByUser( );
    }

    private void setUpLibrary( )
    {
        Map<MediaType, List<MediaEntity>> data = new HashMap<>( );

        data.put( MediaType.MP3, Arrays.asList( this.library.newMusic( "Rock" ),
                                                this.library.newMusic( "Pop" ),
                                                this.library.newMusic( "Classical" ) ) );

        data.put( MediaType.VIDEO, Arrays.asList( this.library.newVideo( "Documentary" ),
                                                  this.library.newVideo( "Movie" ),
                                                  this.library.newVideo( "Show" ) ) );

        data.put( MediaType.BOOK, Arrays.asList( this.library.newBook( "Adventure" ),
                                                 this.library.newBook( "Sci-Fi" ),
                                                 this.library.newBook( "Fantasy" ) ) );
        when( library.load( ) ).thenReturn( data );
    }

    private void setUpMediaEntitiesByUser( )
    {
        Map<String, List<MediaEntity>> data = new HashMap<>( );

        data.put( "dan", Arrays.asList( this.library.newBook( "Sci-Fi" ) ) );
        data.put( "daniel", Arrays.asList( this.library.newBook( "Fantasy" ), this.library.newMusic( "Rock" ) ) );

        when( library.getMediaEntitiesByUser( ) ).thenReturn( data );
    }

    @Test
    public void builder_returns_rock_mp3( )
    {
        Mp3 mp3 = library.newMusic( "Rock" );

        assertThat( mp3.getAlbum( ), is( "Rock Album" ) );
        assertThat( mp3.getSinger( ), is( "Rock Singer" ) );
        assertThat( mp3.getTitle( ), is( "Rock Title" ) );
        assertThat( mp3.getType( ), is( MediaType.MP3 ) );
        assertThat( mp3.getNoOfDownloads( ), is( lessThan( 1000 ) ) );
    }

    @Test
    public void builder_returns_fantasy_book( )
    {
        Book book = library.newBook( "Fantasy" );

        assertThat( book.getAuthor( ), is( "Fantasy Author" ) );
        assertThat( book.getPublisher( ), is( "Fantasy Publisher" ) );
        assertThat( book.getTitle( ), is( "Fantasy Title" ) );
        assertThat( book.getType( ), is( MediaType.BOOK ) );
        assertThat( book.getNoOfDownloads( ), is( lessThan( 1000 ) ) );
    }

    @Test
    public void builder_returns_documentary_video( )
    {
        Video video = library.newVideo( "Documentary" );

        assertThat( video.getDuration( ), is( lessThan( 120 ) ) );
        assertThat( video.getNoOfDownloads( ), is( lessThan( 1000 ) ) );
        assertThat( video.getTitle( ), is( "Documentary Video" ) );
        assertThat( video.getType( ), is( MediaType.VIDEO ) );
    }

    @Test
    public void not_available_media_entities_return_empty_result( )
    {
        Map<MediaType, List<MediaEntity>> inLibrary = library.inLibrary( Arrays.asList( library.newMusic( "Disco" ) ) );

        assertThat( inLibrary.values( ), is( empty( ) ) );
    }

    @Test
    public void available_media_entities_are_returned( )
    {
        Map<MediaType, List<MediaEntity>> inLibrary = library.inLibrary( Arrays.asList( library.newMusic( "Rock" ) ) );

        assertThat( inLibrary.get( MediaType.MP3 ), hasSize( 1 ) );
        assertThat( inLibrary.get( MediaType.MP3 ).get( 0 ), hasProperty( "title", is( "Rock Title" ) ) );
    }

    @Test
    public void only_available_media_entities_are_returned( )
    {
        Map<MediaType, List<MediaEntity>> inLibrary = library.inLibrary( Arrays.asList( library.newMusic( "Rock" ),
                                                                                        library.newMusic( "Demo" ) ) );

        assertThat( inLibrary.get( MediaType.MP3 ), hasSize( 1 ) );
        assertThat( inLibrary.get( MediaType.MP3 ).get( 0 ), hasProperty( "title", is( "Rock Title" ) ) );
    }

    @Test
    public void users_not_accessing_the_library_are_not_considered( )
    {
        Set<String> usersOfMediaEntities = library.getUsersOfMediaEntities( Arrays.asList( "test" ),
                                                                            Arrays.asList( this.library.newMusic( "Rock" ) ) );

        assertThat( usersOfMediaEntities, is( empty( ) ) );
    }

    @Test
    public void users_not_accessing_the_targeted_media_entities_are_not_considered( )
    {
        Set<String> usersOfMediaEntities = library.getUsersOfMediaEntities( Arrays.asList( "dan" ),
                                                                            Arrays.asList( this.library.newMusic( "Rock" ) ) );

        assertThat( usersOfMediaEntities, is( empty( ) ) );
    }

    @Test
    public void users_accessing_at_least_one_targeted_media_entity_are_considered( )
    {
        Set<String> usersOfMediaEntities = library.getUsersOfMediaEntities( Arrays.asList( "daniel" ),
                                                                            Arrays.asList( this.library.newMusic( "Rock" ) ) );

        assertThat( usersOfMediaEntities, hasSize( 1 ) );
        assertThat( usersOfMediaEntities, contains( is( "daniel" ) ) );
    }

    @Test
    public void users_accessing_multiple_targeted_media_entities_are_considered_just_once( )
    {
        Set<String> usersOfMediaEntities = library.getUsersOfMediaEntities( Arrays.asList( "daniel" ),
                                                                            Arrays.asList( this.library.newMusic( "Rock" ),
                                                                                           this.library.newBook( "Fantasy" ) ) );

        assertThat( usersOfMediaEntities, hasSize( 1 ) );
        assertThat( usersOfMediaEntities, contains( is( "daniel" ) ) );
    }

    @Test
    public void only_users_accessing_targeted_media_entities_are_considered( )
    {
        Set<String> usersOfMediaEntities = library.getUsersOfMediaEntities( Arrays.asList( "dan", "daniel" ),
                                                                            Arrays.asList( this.library.newMusic( "Rock" ),
                                                                                           this.library.newBook( "Sci-Fi" ) ) );

        assertThat( usersOfMediaEntities, hasSize( 2 ) );
        assertThat( usersOfMediaEntities, containsInAnyOrder( is( "daniel" ), is( "dan" ) ) );
    }
}
