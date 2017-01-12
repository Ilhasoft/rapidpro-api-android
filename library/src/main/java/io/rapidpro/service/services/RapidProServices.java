package io.rapidpro.service.services;

import java.util.Date;

import io.rapidpro.models.ApiResponse;
import io.rapidpro.models.Contact;
import io.rapidpro.models.FlowDefinition;
import io.rapidpro.models.FlowRun;
import io.rapidpro.models.Message;
import io.rapidpro.service.RapidProAPI;
import io.rapidpro.service.endpoints.RapidProEndPoint;
import io.rapidpro.typeadapters.GsonDateTypeAdapter;
import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by gualberto on 6/13/16.
 */
public class RapidProServices {

    private final String token;
    private final RapidProEndPoint rapidProEndPoint;
    private final GsonDateTypeAdapter gsonDateTypeAdapter;

    public RapidProServices(String host, String token) {
        this.token = token;
        rapidProEndPoint = RapidProAPI.buildApi(host, RapidProEndPoint.class);
        gsonDateTypeAdapter = new GsonDateTypeAdapter();
    }

    public Call<ApiResponse<FlowRun>> loadRuns(String userUuid, Date after) {
        return rapidProEndPoint.listRuns(token, userUuid, gsonDateTypeAdapter.serializeDate(after));
    }

    public Call<FlowDefinition> loadFlowDefinition(String flowUuid) {
        return rapidProEndPoint.loadFlowDefinition(token, flowUuid);
    }

    public Call<Contact> loadContact(String urn) {
        return rapidProEndPoint.loadContact(token, urn);
    }

    public Call<ApiResponse<Contact>> loadContactsByUrn(String urn) {
        return rapidProEndPoint.loadContacts(token, urn);
    }

    public Call<ResponseBody> sendReceivedMessage(String channel, String from, String msg) {
        return rapidProEndPoint.sendReceivedMessage(token, channel, from, msg);
    }

    public Call<Contact> saveContact(Contact contact) {
        return rapidProEndPoint.saveContact(token, contact);
    }

    public Call<ApiResponse<Message>> loadMessages(String contactUuid) {
        return rapidProEndPoint.listMessages(token, contactUuid);
    }

    public Call<ApiResponse<Message>> loadMessageById(Integer messageId) {
        return rapidProEndPoint.listMessageById(token, messageId);
    }

}
