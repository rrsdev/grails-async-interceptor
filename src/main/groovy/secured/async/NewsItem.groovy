package secured.async

import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor
class NewsItem
{
    String title;

    List<Integer> authors;

    String body;

}
