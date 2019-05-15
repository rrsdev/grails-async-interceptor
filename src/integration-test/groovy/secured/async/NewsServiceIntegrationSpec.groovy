package secured.async

import grails.gorm.transactions.Rollback
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import grails.testing.mixin.integration.Integration
import groovy.util.logging.Slf4j
import spock.lang.Specification

@Slf4j
@Rollback
@Integration
class NewsServiceIntegrationSpec extends Specification
{

    RestBuilder restBuilder;

    def setup()
    {
        restBuilder = new RestBuilder();
    }

    void "test intercepted webservice with webpromise"() {
        when:
        RestResponse response = restBuilder.get("http://localhost:${serverPort}/data/news");

        then:
        response.status == 200
        response.json != null;
        response.json.items[1].title == 'def';
    }

    void "test intercepted webservice with no-async"() {
        when:
        RestResponse response = restBuilder.get("http://localhost:${serverPort}/data/news2");

        then:
        response.status == 200
        response.json != null;
        response.json.items[1].title == 'def';
    }

    void "test non-intercepted webservice with webpromise"() {
        when:
        RestResponse response = restBuilder.get("http://localhost:${serverPort}/feed/news");

        then:
        response.status == 200
        response.json != null;
        response.json.items[1].title == 'def';
    }

    void "test non-intercepted webservice with no-async"() {
        when:
        RestResponse response = restBuilder.get("http://localhost:${serverPort}/feed/news2");

        then:
        response.status == 200
        response.json != null;
        response.json.items[1].title == 'def';
    }
}
