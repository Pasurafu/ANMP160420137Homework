package util

class util {
    fun createNotificationChannel(context: Context, importance: Int, showBadge:
    Boolean, name: String, description: String) {    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {val channelId = "${context.packageName}-$name"
        val channel = NotificationChannel(channelId, name, importance)
        channel.description = description
        channel.setShowBadge(showBadge)
        val notificationManager = context.getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel) }}
}