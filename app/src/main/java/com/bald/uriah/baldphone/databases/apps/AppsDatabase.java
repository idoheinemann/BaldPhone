/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.bald.uriah.baldphone.databases.apps;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {App.class}, version = 1, exportSchema = false)
public abstract class AppsDatabase extends RoomDatabase {
    private static final Object LOCK = new Object();
    private static AppsDatabase appsDatabase = null;

    public static AppsDatabase getInstance(Context context) {
        synchronized (LOCK) {
            if (appsDatabase == null)
                appsDatabase = Room.databaseBuilder(context.getApplicationContext(),
                        AppsDatabase.class, "applications").allowMainThreadQueries().build();
            return appsDatabase;
        }
    }

    public abstract AppsDatabaseDao appsDatabaseDao();
}
