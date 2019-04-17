package problems.design.library;

import problems.design.library.model.*;

import java.util.*;

public class Library
{
    private Random random = new Random( System.currentTimeMillis( ) );

    /*
     * Return the media entities from the wanted list that are found in the library grouped by media type
     */
    public Map<MediaType, List<MediaEntity>> inLibrary( List<MediaEntity> wanted )
    {
        Map<MediaType, List<MediaEntity>> result  = new HashMap<>( );
        Map<MediaType, List<MediaEntity>> library = load( );

        for( MediaEntity wantedEntity : wanted )
        {
            if( !library.containsKey( wantedEntity.getType( ) ) )
            {
                continue;
            }

            List<MediaEntity> availableEntities = library.get( wantedEntity.getType( ) );

            if( availableEntities.contains( wantedEntity ) )
            {
                List<MediaEntity> entityList = result.get( wantedEntity.getType( ) );

                if( entityList == null )
                {
                    entityList = new ArrayList<>( );
                    result.put( wantedEntity.getType( ), entityList );
                }

                entityList.add( wantedEntity );
            }
        }

        return result;
    }

    /*
     * Return only the users that accessed at least of the specified media entities
     */
    public Set<String> getUsersOfMediaEntities( List<String> users, List<MediaEntity> mediaEntities )
    {
        Set<String>                    result          = new HashSet<>( );
        Map<String, List<MediaEntity>> userAndEntities = getMediaEntitiesByUser( );

        for( String user : users )
        {
            if( !userAndEntities.containsKey( user ) )
            {
                continue;
            }

            List<MediaEntity> accessedMediaEntities = userAndEntities.get( user );

            for( MediaEntity wantedEntity : mediaEntities )
            {
                if( accessedMediaEntities.contains( wantedEntity ) )
                {
                    result.add( user );
                }
            }
        }

        return result;
    }

    /*
     * Media entities in the library grouped by type
     */
    public Map<MediaType, List<MediaEntity>> load( )
    {
        return Collections.emptyMap( );
    }

    /*
     * Media entities accessed by each user
     */
    public Map<String, List<MediaEntity>> getMediaEntitiesByUser( )
    {
        return Collections.emptyMap( );
    }

    public Mp3 newMusic( String seed )
    {
        return new Mp3Builder( ).album( seed + " Album" )
                                .singer( seed + " Singer" )
                                .title( seed + " Title" )
                                .noOfDownloads( random.nextInt( 1000 ) )
                                .build( );
    }

    public Video newVideo( String seed )
    {
        return new VideoBuilder( ).title( seed + " Video" )
                                  .duration( random.nextInt( 120 ) )
                                  .fullHD( false )
                                  .noOfDownloads( random.nextInt( 1000 ) )
                                  .build( );
    }

    public Book newBook( String seed )
    {
        return new BookBuilder( ).title( seed + " Title" )
                                 .author( seed + " Author" )
                                 .publisher( seed + " Publisher" )
                                 .noOfDownloads( random.nextInt( 1000 ) )
                                 .build( );
    }
}
