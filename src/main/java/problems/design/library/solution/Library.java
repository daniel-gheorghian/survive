package problems.design.library.solution;

import problems.design.library.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class Library
{
    private Random random = new Random( System.currentTimeMillis( ) );

    public Map<MediaType, List<MediaEntity>> inLibrary( List<MediaEntity> wanted )
    {
        Map<MediaType, List<MediaEntity>> library = load( );

        return wanted.stream( )
                     .filter( wantedEntity -> library.containsKey( wantedEntity.getType( ) ) )
                     .filter( wantedEntity -> library.get( wantedEntity.getType( ) ).contains( wantedEntity ) )
                     .collect( Collectors.groupingBy( MediaEntity::getType ) );
    }

    public Set<String> getUsersOfMediaEntities( List<String> users, List<MediaEntity> mediaEntities )
    {
        Map<String, List<MediaEntity>> userAndEntities = getMediaEntitiesByUser( );

        return users.stream( )
                    .filter( userAndEntities::containsKey )
                    .filter( user -> !intersect( userAndEntities.get( user ), mediaEntities ).isEmpty( ) )
                    .collect( Collectors.toSet( ) );
    }

    private <T> List<T> intersect( List<T> a, List<T> b )
    {
        List<T> result = new ArrayList<>( a );
        result.retainAll( b );

        return result;
    }

    public Map<MediaType, List<MediaEntity>> load( )
    {
        return Collections.emptyMap( );
    }

    public Map<String, List<MediaEntity>> getMediaEntitiesByUser( )
    {
        return Collections.emptyMap( );
    }

    public Mp3 newMusic( String seed )
    {
        return MediaEntityBuilder.mp3( )
                                 .album( seed + " Album" )
                                 .singer( seed + " Singer" )
                                 .title( seed + " Title" )
                                 .noOfDownloads( random.nextInt( 1000 ) );
    }

    public Video newVideo( String seed )
    {
        return MediaEntityBuilder.video( )
                                 .title( seed + " Video" )
                                 .duration( random.nextInt( 120 ) )
                                 .fullHD( false )
                                 .noOfDownloads( random.nextInt( 1000 ) );
    }

    public Book newBook( String seed )
    {
        return MediaEntityBuilder.book( )
                                 .title( seed + " Title" )
                                 .author( seed + " Author" )
                                 .publisher( seed + " Publisher" )
                                 .noOfDownloads( random.nextInt( 1000 ) );
    }
}
