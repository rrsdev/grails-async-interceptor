package secured.async

import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor
class News
{
    List<NewsItem> items;
}
