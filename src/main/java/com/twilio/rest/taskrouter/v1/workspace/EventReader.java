/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.taskrouter.v1.workspace;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

public class EventReader extends Reader<Event> {
    private final String pathWorkspaceSid;
    private DateTime endDate;
    private String eventType;
    private Integer minutes;
    private String reservationSid;
    private DateTime startDate;
    private String taskQueueSid;
    private String taskSid;
    private String workerSid;
    private String workflowSid;

    /**
     * Construct a new EventReader.
     * 
     * @param pathWorkspaceSid The workspace_sid
     */
    public EventReader(final String pathWorkspaceSid) {
        this.pathWorkspaceSid = pathWorkspaceSid;
    }

    /**
     * Filter events by an end date. This is helpful for defining a range of events
     * to capture. Input is a GMT ISO 8601 Timestamp..
     * 
     * @param endDate Filter events by an end date.
     * @return this
     */
    public EventReader setEndDate(final DateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Filter events by those of a certain event type.
     * 
     * @param eventType Filter events by those of a certain event type
     * @return this
     */
    public EventReader setEventType(final String eventType) {
        this.eventType = eventType;
        return this;
    }

    /**
     * Filter events by up to ‘x’ minutes in the past. This is helpful for events
     * for the last 15 minutes, 240 minutes (4 hours), and 480 minutes (8 hours) to
     * see trends. Defaults to 15 minutes..
     * 
     * @param minutes Filter events by up to ‘x’ minutes in the past.
     * @return this
     */
    public EventReader setMinutes(final Integer minutes) {
        this.minutes = minutes;
        return this;
    }

    /**
     * Filter events by those pertaining to a particular reservation.
     * 
     * @param reservationSid Filter events by those pertaining to a particular
     *                       reservation
     * @return this
     */
    public EventReader setReservationSid(final String reservationSid) {
        this.reservationSid = reservationSid;
        return this;
    }

    /**
     * Filter events by a start date. This is helpful for defining a range of events
     * to capture. Input is a GMT ISO 8601 Timestamp..
     * 
     * @param startDate Filter events by a start date.
     * @return this
     */
    public EventReader setStartDate(final DateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Filter events by those pertaining to a particular queue.
     * 
     * @param taskQueueSid Filter events by those pertaining to a particular queue
     * @return this
     */
    public EventReader setTaskQueueSid(final String taskQueueSid) {
        this.taskQueueSid = taskQueueSid;
        return this;
    }

    /**
     * Filter events by those pertaining to a particular task.
     * 
     * @param taskSid Filter events by those pertaining to a particular task
     * @return this
     */
    public EventReader setTaskSid(final String taskSid) {
        this.taskSid = taskSid;
        return this;
    }

    /**
     * Filter events by those pertaining to a particular worker.
     * 
     * @param workerSid Filter events by those pertaining to a particular worker
     * @return this
     */
    public EventReader setWorkerSid(final String workerSid) {
        this.workerSid = workerSid;
        return this;
    }

    /**
     * The workflow_sid.
     * 
     * @param workflowSid The workflow_sid
     * @return this
     */
    public EventReader setWorkflowSid(final String workflowSid) {
        this.workflowSid = workflowSid;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Event ResourceSet
     */
    @Override
    public ResourceSet<Event> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Event ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Event> firstPage(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.TASKROUTER.toString(),
            "/v1/Workspaces/" + this.pathWorkspaceSid + "/Events",
            client.getRegion()
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the target page from the Twilio API.
     * 
     * @param targetUrl API-generated URL for the requested results page
     * @param client TwilioRestClient with which to make the request
     * @return Event ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Event> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     * 
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<Event> nextPage(final Page<Event> page, 
                                final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(
                Domains.TASKROUTER.toString(),
                client.getRegion()
            )
        );
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the previous page from the Twilio API.
     * 
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Previous Page
     */
    @Override
    public Page<Event> previousPage(final Page<Event> page, 
                                    final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(
                Domains.TASKROUTER.toString(),
                client.getRegion()
            )
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of Event Resources for a given request.
     * 
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<Event> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Event read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Page.fromJson(
            "events",
            response.getContent(),
            Event.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     * 
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (endDate != null) {
            request.addQueryParam("EndDate", endDate.toString());
        }

        if (eventType != null) {
            request.addQueryParam("EventType", eventType);
        }

        if (minutes != null) {
            request.addQueryParam("Minutes", minutes.toString());
        }

        if (reservationSid != null) {
            request.addQueryParam("ReservationSid", reservationSid);
        }

        if (startDate != null) {
            request.addQueryParam("StartDate", startDate.toString());
        }

        if (taskQueueSid != null) {
            request.addQueryParam("TaskQueueSid", taskQueueSid);
        }

        if (taskSid != null) {
            request.addQueryParam("TaskSid", taskSid);
        }

        if (workerSid != null) {
            request.addQueryParam("WorkerSid", workerSid);
        }

        if (workflowSid != null) {
            request.addQueryParam("WorkflowSid", workflowSid);
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}