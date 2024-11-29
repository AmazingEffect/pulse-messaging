package com.pulse.talk.application.port.out.grpc;

import com.pulse.content.grpc.MemberProto;
import io.opentelemetry.context.Context;

public interface GrpcMemberClientPort {

    MemberProto.MemberRetrieveResponse getMemberById(Long id, Context context);

    MemberProto.MemberNicknameResponse getNicknameById(Long id, Context context);

    MemberProto.MemberProfileImageUrlResponse getProfileImageUrl(Long id, Context context);
}
