package com.example.usagestats;

import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import java.util.List;

public class UsageStatsHelper {

    private UsageStatsManager usageStatsManager;

    public UsageStatsHelper(Context context) {
        usageStatsManager = (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);
    }

    public void logAppUsage() {
        long currentTime = System.currentTimeMillis();
        List<UsageStats> usageStatsList = usageStatsManager.queryUsageStats(
                UsageStatsManager.INTERVAL_DAILY, 0, currentTime
        );

        // Log or process the usage stats data
        if (usageStatsList != null) {
            for (UsageStats stats : usageStatsList) {
                System.out.println("Package: " + stats.getPackageName() + " - Time: " + stats.getTotalTimeInForeground());
            }
        }
    }
}
