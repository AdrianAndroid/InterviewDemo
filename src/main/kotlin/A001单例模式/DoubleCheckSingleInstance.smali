.class public LA001单例模式/DoubleCheckSingleInstance;
.super Ljava/lang/Object;
.source "DoubleCheckSingleInstance.java"


# static fields
.field private static volatile instance:LA001单例模式/DoubleCheckSingleInstance;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 4
    const/4 v0, 0x0

    sput-object v0, LA001单例模式/DoubleCheckSingleInstance;->instance:LA001单例模式/DoubleCheckSingleInstance;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInstance()LA001单例模式/DoubleCheckSingleInstance;
    .registers 2

    .prologue
    .line 7
    sget-object v0, LA001单例模式/DoubleCheckSingleInstance;->instance:LA001单例模式/DoubleCheckSingleInstance;

    if-nez v0, :cond_13

    .line 8
    const-class v1, LA001单例模式/DoubleCheckSingleInstance;

    monitor-enter v1

    .line 9
    :try_start_7
    sget-object v0, LA001单例模式/DoubleCheckSingleInstance;->instance:LA001单例模式/DoubleCheckSingleInstance;

    if-nez v0, :cond_12

    .line 10
    new-instance v0, LA001单例模式/DoubleCheckSingleInstance;

    invoke-direct {v0}, LA001单例模式/DoubleCheckSingleInstance;-><init>()V

    sput-object v0, LA001单例模式/DoubleCheckSingleInstance;->instance:LA001单例模式/DoubleCheckSingleInstance;

    .line 12
    :cond_12
    monitor-exit v1
    :try_end_13
    .catchall {:try_start_7 .. :try_end_13} :catchall_16

    .line 14
    :cond_13
    sget-object v0, LA001单例模式/DoubleCheckSingleInstance;->instance:LA001单例模式/DoubleCheckSingleInstance;

    return-object v0

    .line 12
    :catchall_16
    move-exception v0

    :try_start_17
    monitor-exit v1
    :try_end_18
    .catchall {:try_start_17 .. :try_end_18} :catchall_16

    throw v0
.end method
