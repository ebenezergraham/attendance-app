class AttendantRecord {
  String userId;
  String qrCodeId;
  String username;
  String time;
  String session;

  AttendantRecord(
      {this.userId, this.qrCodeId, this.username, this.time, this.session});

  factory AttendantRecord.fromJson(Map<String, dynamic> json) {
    return AttendantRecord(
      userId: json['userId'],
      qrCodeId: json['qrCodeId'],
      username: json['username'],
      time: json['time'],
      session: json['session'],
    );
  }

  /*
  * {
              "userId": "Test",
              "qrCodeId": "Test",
              "username": "Test",
              "time": "Test",
              "session": "Test"
            }
  * */
  Map<String, dynamic> toJson() => {
        'userId': userId,
        'qrCodeId': qrCodeId,
        'username': username,
        'time': time,
        'session': session,
      };
}
