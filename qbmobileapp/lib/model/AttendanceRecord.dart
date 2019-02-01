class Post {
  final int userId;
  final int qrCodeId;
  final String time;
  final String session;

  Post({this.userId, this.qrCodeId, this.time, this.session});

  factory Post.fromJson(Map<String, dynamic> json) {
    return Post(
      userId: json['userId'],
      qrCodeId: json['qrCodeId'],
      time: json['time'],
      session: json['session'],
    );
  }
}
